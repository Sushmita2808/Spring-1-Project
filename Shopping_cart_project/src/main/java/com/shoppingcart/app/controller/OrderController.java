package com.shoppingcart.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcart.app.exception.OrderNotFoundException;
import com.shoppingcart.app.model.Order;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.OrderService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private  OrderService   orderService ;
	
		//Find All
		@GetMapping
		public List<Order> getAllOrders(){
			return  orderService.findAll();
		}
	
		//Add Order
		@PostMapping
		public MessageResponse createOrder(@RequestBody Order order) {
			return  orderService.save(order);
		}
	
		//Find By Id
		@GetMapping("/getbyid/{id}")
		public Order getOrderById(@PathVariable  long id) throws OrderNotFoundException{
			
			Optional<Order> order= orderService.getById(id);  
			if (order.isPresent()) {
				return order.get();
			}
			
		    throw  new OrderNotFoundException("Order not exist with id:" + id);	
		}	
		
		//get all status=true
	    @GetMapping("/sortByStatus")
	    public List<Order> getOrderByStatus(@RequestBody  Order  orderDetails) throws OrderNotFoundException{
	        return orderService.getByStatus(true);
	             
	    } 
	    
	    //Get Orders records by page
	    @GetMapping("/getbypage")
		public ResponseEntity<List<Order>> getOrders() throws OrderNotFoundException {
	    
			 List<Order> list = orderService.paging();
				
				if(list.size()<=0) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				return new ResponseEntity<List<Order>>(orderService.paging(), HttpStatus.OK);
			}
	    
	    //sorting
	    @GetMapping("/getbysort")
		 public List<Order> getOrdersbysort(@RequestBody Order order) throws OrderNotFoundException {
			 
			  return (List<Order>) orderService.sorting(order);
	             
		    }
	    
		
		//Update Order
	    @PutMapping("{id}")
	  	public Order updateOrder(@RequestBody Order order, @PathVariable long id) {
	    	order.setOrderNumber(id);
	  		return orderService.update(order);
	    }
	   
		//Delete By Id
		@DeleteMapping("{id}")
		public MessageResponse deleteOrderById(@PathVariable long id) throws OrderNotFoundException{
			
			try{
				   
				orderService.getById(id);
				}
			catch(OrderNotFoundException e) {
				
				e.printStackTrace();
				}
			 return orderService.deleteById(id);
		}
	}