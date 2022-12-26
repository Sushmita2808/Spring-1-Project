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

import com.shoppingcart.app.exception.OrderDetailNotFoundException;
import com.shoppingcart.app.model.OrderDetail;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.OrderDetailService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/orderdetails")
public class OrderDetailController {

	@Autowired
	private OrderDetailService  orderDetailService ;
	
		//Find all
		@GetMapping
		public List<OrderDetail> getAllorderDetails(){
			return orderDetailService.findAll();
		}
	
		//Add OrderDetail
		@PostMapping
		public MessageResponse createOrderDetail(@RequestBody OrderDetail orderDetail) {
			return orderDetailService.save(orderDetail);
		}
	 
		//Find By Id
		@GetMapping("/getbyid/{id}")
		public OrderDetail getOrderDetailById(@PathVariable  long id) throws OrderDetailNotFoundException{
		
			Optional<OrderDetail> orderDetail = orderDetailService.getById(id);  
			if (orderDetail.isPresent()) {
				return orderDetail.get();
			}
			
		    throw  new OrderDetailNotFoundException("OrderDetail not exist with id:" + id);	
		}	
	
		
		//Sort the Order List by price
	    @GetMapping("/getbyprice/{priceEach}")
	    public List<OrderDetail> getAllPrice(@PathVariable double priceEach) throws OrderDetailNotFoundException{
	        return orderDetailService.findGreaterthanEqualByPrice(priceEach);
	             
	    }
	    
	    //Get Orderdetails records by page
	    @GetMapping("/getbypage")
		public ResponseEntity<List<OrderDetail>> getOrderDetails() throws OrderDetailNotFoundException {
	    	 List<OrderDetail> list =orderDetailService.paging();
				
				if(list.size()<=0) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				return new ResponseEntity<List<OrderDetail>>(orderDetailService.paging(), HttpStatus.OK);
			}
		 
	    //sorting
	    @GetMapping("/getbysort")
		 public List<OrderDetail> getOrderDetailsbysort(@RequestBody OrderDetail orderDetail) throws OrderDetailNotFoundException {
			 
			  return (List<OrderDetail>) orderDetailService.sorting(orderDetail);
	             
		    }

		//Update orderDetail
	    @PutMapping("{id}")
	  	public OrderDetail updateOrderDetail(@RequestBody OrderDetail orderDetail, @PathVariable long id) {
	  		
	    	orderDetail.setQuantityOrdered(id);
			
			return orderDetailService.update(orderDetail);
		   
			}	
			 
		//Delete By id
		@DeleteMapping("{id}")
		public MessageResponse deleteOrderDetailById(@PathVariable long id) throws OrderDetailNotFoundException{

			try{
				   
				orderDetailService.getById(id);
		   
			}
			catch(OrderDetailNotFoundException e) {
				
				e.printStackTrace();
			}
			return orderDetailService.deleteById(id);
  	  }
}
		