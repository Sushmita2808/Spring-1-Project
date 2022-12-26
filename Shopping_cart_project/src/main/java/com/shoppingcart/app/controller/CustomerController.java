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

import com.shoppingcart.app.exception.CustomerNotFoundException;
import com.shoppingcart.app.model.Customer;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.CustomerService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/customers")

public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
		//Find all customer
		@GetMapping
		public List<Customer> getAllCustomers(){
			return customerService.findAll();
		}
	
		//Add new customer
		@PostMapping
		public MessageResponse createCustomer(@RequestBody Customer customer) {
			return customerService.save(customer);
		}
	
		//Find customer by id
		@GetMapping("/getbyid/{id}")
		public Customer getCustomerById(@PathVariable  long id) throws CustomerNotFoundException {
			Optional<Customer> customer = customerService.getById(id);  
			if (customer.isPresent()) {
				return customer.get();
			}
			
		    throw  new CustomerNotFoundException("Customer not exist with id:" + id);			
		}		
		
		//Sort the Customer List
		@GetMapping("/sortbyname")
	    public List<Customer> findAllSortedByName(@RequestBody Customer customerdetails) throws CustomerNotFoundException{
	        return customerService.sortedByName(customerdetails);
	             
	    }
		
		//Sort the Customer List
		@GetMapping("/getbylastname/{contactLastName}")
	    public ResponseEntity<List<Customer>> findByLastName(@PathVariable  String contactLastName){
	    	  List<Customer> customers = customerService.getByLastName(contactLastName);

	    	  if(customers  == null) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				return ResponseEntity.of(Optional.of(customers ));
			}
		
		//get by page
		 @GetMapping("/getbypage")
		 public ResponseEntity<List<Customer>> getCustomersbypage() throws CustomerNotFoundException {
			 
			 List<Customer> list = customerService.paging();
				
				if(list.size()<=0) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				return new ResponseEntity<List<Customer>>(customerService.paging(), HttpStatus.OK);
			}
		 
		 //sorting
		 @GetMapping("/getbysort")
		 public List<Customer> getCustomersbysort(@RequestBody Customer customerdetails) throws CustomerNotFoundException {
			 
			  return (List<Customer>) customerService.sorting(customerdetails);
	             
		    }
		    
		//update Employee 
		@PutMapping("/update/{id}")
		public Customer updateCustomer(@PathVariable long id,@RequestBody Customer customer) {
		
		customer.setCustomerNumber(id);
			
		return customerService.update(customer);
	   
		}	
		   
		//Delete customer by Id
		@DeleteMapping("{id}")
		public  MessageResponse deleteCustomerById(@PathVariable long id) throws CustomerNotFoundException{
			
			try{
		   
				customerService.getById(id);
		   
			}
			catch(CustomerNotFoundException e) {
				
				e.printStackTrace();
			}
			 return customerService.deleteById(id);
  	  }
}
		

