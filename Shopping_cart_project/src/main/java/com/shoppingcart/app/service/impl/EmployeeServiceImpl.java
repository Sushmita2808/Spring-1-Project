package com.shoppingcart.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.Employee;
import com.shoppingcart.app.repository.EmployeeRepository;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public MessageResponse save(Employee employee) {
		
		Employee newEmployee = new Employee ();
		newEmployee.setLastName(employee.getLastName());
		newEmployee.setFirstName(employee.getFirstname());
		newEmployee.setExtension(employee.getExtension());
		newEmployee.setEmail(employee.getEmail());
		newEmployee.setOfficeCode(employee.getOfficeCode());
		newEmployee.setReportsTo(employee.getReportsTo());
		newEmployee.setJobTitle(employee.getJobTitle());
		employeeRepository.save(newEmployee);
		
		return new MessageResponse("New employee record  created successfully");

	}

	@Override
	public Optional<Employee> getById(long id) {
		
	return employeeRepository.findById(id);
		
	}	
		
	@Override
	public List<Employee> sortedByEmail(Employee employeedetails) {
		return employeeRepository.findAllSortedByEmail();
	}

	@Override
	public List<Employee> getByName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	@Override
	public List<Employee> paging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Employee> list =employeeRepository.findEmployees(pageable);
		return list;
	}

	@Override
	public Iterable<Employee> sorting(Employee employeedetails) {
		String sortBy = "last_name";
		List<Employee> list = (List<Employee>) employeeRepository.sortEmployee(Sort.by(Sort.Direction.ASC,sortBy));
		return list;
	}
	
	@Override
	public MessageResponse deleteById(long id) {
		employeeRepository.findById(id);
		
		employeeRepository.deleteById(id);
		 
		return new MessageResponse("Employee  record deleted successfully");

	}

	@Override
	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}

}
