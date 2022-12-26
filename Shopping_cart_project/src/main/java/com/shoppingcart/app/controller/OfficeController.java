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

import com.shoppingcart.app.exception.OfficeNotFoundException;
import com.shoppingcart.app.model.Office;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.OfficeService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/offices")
public class OfficeController {
	
	@Autowired
	private OfficeService officeService;
	
		//Find all office
		@GetMapping
		public List<Office> getAllOffices(){
			return officeService.findAll();
		}
	
		//Add office
		@PostMapping
		public MessageResponse createOffice(@RequestBody Office office) {
			return officeService.save(office);
		}
	
		//Find by Id
		@GetMapping("/getbyid/{id}")
		public Office getOfficeById(@PathVariable  long id) throws OfficeNotFoundException{
			
			Optional<Office> office= officeService.getById(id);  
			if (office.isPresent()) {
				return office.get();
			}
			
		    throw  new OfficeNotFoundException("Office not exist with id:" + id);	
		}	
		
		//Sort the office by state
	    @GetMapping("/sortbystate")
	    public List<Office> findAllSortedByState(@RequestBody  Office  officeDetails) throws OfficeNotFoundException{
	        return officeService.sortedByState(officeDetails);
	             
	    }
	    
	    //Get offices records by page
	    @GetMapping("/getbypage")
		public ResponseEntity<List<Office>> getOffices() throws OfficeNotFoundException {
	     
			 List<Office> list = officeService.paging();
				
				if(list.size()<=0) {
					return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				}
				
				return new ResponseEntity<List<Office>>(officeService.paging(), HttpStatus.OK);
		}
	    
	    //sorting
	    @GetMapping("/getbysort")
		 public List<Office> getOfficesbysort(@RequestBody Office officedetails) throws OfficeNotFoundException {
			 
			  return (List<Office>) officeService.sorting(officedetails);
	             
		 }

		//Update office
	  	@PutMapping("{id}")
	  	public Office updateOffice(@RequestBody Office office, @PathVariable long id) {
	  		
	  			office.setOfficeCode(id);
	  			
	  			return officeService.update(office);
	  	}
	  		
		//Delete By Id 
		@DeleteMapping("{id}")
		public MessageResponse deleteOfficeById(@PathVariable long id) throws OfficeNotFoundException{

			try{
				   
				officeService.getById(id);
		   
			}
			catch(OfficeNotFoundException e) {
				
				e.printStackTrace();
			}
			 return officeService.deleteById(id);
		}
}
		

