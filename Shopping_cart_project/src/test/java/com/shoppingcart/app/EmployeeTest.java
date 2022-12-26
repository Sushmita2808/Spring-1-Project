package com.shoppingcart.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.app.model.Employee;
import com.shoppingcart.app.repository.EmployeeRepository;
import com.shoppingcart.app.service.EmployeeService;


@SpringBootTest
public class EmployeeTest {
	
	@Autowired
	private  EmployeeService  employeeService;
	
	@MockBean
	private  EmployeeRepository  employeeRepository;
	
	@Test
	@Order(1)
	@DisplayName(" Testing for creating Employee  ")
	public void  createEmployee() {
		Employee employee = new Employee ();
		employee.setEmployeeNumber(1L);
		employee.setLastName("Kumari");
		employee.setFirstName("Anisha");
		employee.setExtension("Work from Home");
		employee.setEmail("alisha342@gmail.com");
		employee.setOfficeCode("Xyz123");
		employee.setReportsTo("Work is pending");
		employee.setJobTitle("Programmer");
		
		Mockito.when(employeeRepository.save(employee))
		.thenReturn(employee);
		
		assertThat(employeeService.save(employee))
		.isNotNull();
		
		}
	
	@Test
	@Order(2)
	@DisplayName(" Testing for getting Employee by first name  ")
	public void  getbyFirstName() {
		Employee employee = new Employee ();
		employee.setEmployeeNumber(1L);
		employee.setLastName("Kumari");
		employee.setFirstName("Anisha");
		employee.setExtension("Work from Home");
		employee.setEmail("alisha342@gmail.com");
		employee.setOfficeCode("Xyz123");
		employee.setReportsTo("Work is pending");
		employee.setJobTitle("Programmer");
		
		Mockito.when(employeeRepository.save(employee))
		.thenReturn(employee);
		
		assertThat(employeeService.getByName("Anisha"))
		.isNotNull();
		
	
		}
	
	@Test
	@Order(3)
	@DisplayName(" Testing for deleting Employee by Id  ")
	public void  deleteEmployee() {
		Employee employee = new Employee ();
		employee.setEmployeeNumber(1L);
		employee.setLastName("Kumari");
		employee.setFirstName("Anisha");
		employee.setExtension("Work from Home");
		employee.setEmail("alisha342@gmail.com");
		employee.setOfficeCode("Xyz123");
		employee.setReportsTo("Work is pending");
		employee.setJobTitle("Programmer");
		
		Mockito.when(employeeRepository.save(employee))
		.thenReturn(employee);
		
		assertThat(employeeService.deleteById(1L))
		.isNotNull();
		
	
		}
	
	@Test
	@Order(4)
	@DisplayName(" Testing for paging ")
	public void  paging() {
		Employee employee = new Employee ();
		employee.setEmployeeNumber(1L);
		employee.setLastName("Kumari");
		employee.setFirstName("Anisha");
		employee.setExtension("Work from Home");
		employee.setEmail("alisha342@gmail.com");
		employee.setOfficeCode("Xyz123");
		employee.setReportsTo("Work is pending");
		employee.setJobTitle("Programmer");
		
		Mockito.when(employeeRepository.save(employee))
		.thenReturn(employee);
		
		assertThat(employeeService.paging())
		.isNotNull();
		
	
		}
	
	@Test
	@Order(5)
	@DisplayName(" Testing for sorting ")
	public void  sorting() {
		Employee employee = new Employee ();
		employee.setEmployeeNumber(1L);
		employee.setLastName("Kumari");
		employee.setFirstName("Anisha");
		employee.setExtension("Work from Home");
		employee.setEmail("alisha342@gmail.com");
		employee.setOfficeCode("Xyz123");
		employee.setReportsTo("Work is pending");
		employee.setJobTitle("Programmer");
		
		Mockito.when(employeeRepository.save(employee))
		.thenReturn(employee);
		
		assertThat(employeeService.sorting(employee))
		.isNotNull();
		
	
		}


}
