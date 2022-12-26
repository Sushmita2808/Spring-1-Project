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

import com.shoppingcart.app.exception.EmployeeNotFoundException;
import com.shoppingcart.app.model.Employee;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	
		//Find all Employee
		@GetMapping
		public List<Employee> getAllEmployees(){
			return employeeService.findAll();
		}
	
		//Add employee
		@PostMapping
		public MessageResponse createEmployee(@RequestBody Employee employee) {
			return employeeService.save(employee);
		}
	
		//Find employee By Id
		@GetMapping("/getbyid/{id}")
		public Employee getEmployeeById(@PathVariable  long id) throws EmployeeNotFoundException{
			
			Optional<Employee> employee = employeeService.getById(id);  
			if (employee.isPresent()) {
				return employee.get();
			}
			
		    throw  new EmployeeNotFoundException("Employee not exist with id:" + id);	
			
			
		}		
		
		//Sort the Employee List by email
	    @GetMapping("/sortbyemail")
	    public List<Employee> findAllSortedByEmail(@RequestBody Employee  employeesDetails) throws EmployeeNotFoundException{
	        return  employeeService.sortedByEmail(employeesDetails);
	             
	    }
	    
	    //search employee by first name
	    @GetMapping("/getbyfirstname/{firstName}")
		public ResponseEntity<List<Employee>> findEmployeeByFirstName(@PathVariable String firstName){
			List<Employee> employee = employeeService.getByName(firstName);
			
			if(employee == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.of(Optional.of(employee));
		}
	    
	    //Get employees records by page
	    @GetMapping("/getbypage")
		public ResponseEntity<List<Employee>> getEmployees() throws EmployeeNotFoundException {
	    	List<Employee> list = employeeService.paging();
			
			if(list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return new ResponseEntity<List<Employee>>(employeeService.paging(), HttpStatus.OK);
		}
	    
	    //sorting
		 @GetMapping("/getbysort")
		 public List<Employee> getCustomersbysort(@RequestBody Employee  employeesDetails) throws EmployeeNotFoundException {
			 
			  return (List<Employee>) employeeService.sorting(employeesDetails);
	             
		    }
		    
	    
		//Update Employee
	  	@PutMapping("{id}")
	  	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
	  		
	  		employee.setEmployeenumber(id);;
			
			return employeeService.update(employee);
		   
	  		
	  		}


		//Delete By id 
		@DeleteMapping("{id}")
		public MessageResponse deleteEmployeeById(@PathVariable long id) throws EmployeeNotFoundException{

		try{
				   
				employeeService.getById(id);
		   
			}
			catch(EmployeeNotFoundException e) {
				
				e.printStackTrace();
			}
			 return employeeService.deleteById(id);
  	  }
}
		
