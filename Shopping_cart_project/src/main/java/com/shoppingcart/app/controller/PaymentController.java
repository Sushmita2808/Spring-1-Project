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

import com.shoppingcart.app.exception.PaymentNotFoundException;
import com.shoppingcart.app.model.Payment;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.PaymentService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
		//Find all payment
		@GetMapping
		public List<Payment> getAllPayments(){
			return paymentService.findAll();
		}
	
		//Add payment
		@PostMapping
		public MessageResponse createPayment(@RequestBody Payment payment) {
			return paymentService.save(payment);
		}
	
		//Find payment By Id
		@GetMapping("/getbyid/{id}")
		public Payment getPaymentById(@PathVariable  long id) throws PaymentNotFoundException{
			
			Optional<Payment> payment = paymentService.getById(id);  
			if (payment.isPresent()) {
				return payment.get();
			}
			
		    throw  new PaymentNotFoundException("Payment not exist with id:" + id);	
		}	
		
	    //Sort the Payment List by amount
	    @GetMapping("/sortbyamount")
	    public List<Payment> findAllSortedByAmpunt(@RequestBody Payment paymentdetails) throws PaymentNotFoundException{
	        return paymentService.sortedByAmount(paymentdetails);
	             
	    } 
	    
	    //Get Payments records by page
	    @GetMapping("/getbypage")
		public ResponseEntity<List<Payment>> getPayments() throws PaymentNotFoundException {
	     
			 List<Payment> list = paymentService.paging();
				
				if(list.size()<=0) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				return new ResponseEntity<List<Payment>>(paymentService.paging(), HttpStatus.OK);
			}
	    
	  //sorting
	    @GetMapping("/getbysort")
		 public List<Payment> getPaymentsbysort(@RequestBody Payment payment) throws  PaymentNotFoundException {
			 
			  return (List<Payment>) paymentService.sorting(payment);
	             
		    }
	    
		//Update payment
	    @PutMapping("{id}")
	  	public Payment updatePayment(@RequestBody Payment payment, @PathVariable long id) {
	    	payment.setCustomerNumber(id);
			
			return paymentService.update(payment);
		   
			}	
			  

		//Delete By Id 
		@DeleteMapping("{id}")
		public MessageResponse deletePaymentById(@PathVariable long id) throws PaymentNotFoundException{

			try{
				   
				paymentService.getById(id);
		   
			}
			catch(PaymentNotFoundException e) {
				
				e.printStackTrace();
			}
			 return paymentService.deleteById(id);
  	  }
}
		


