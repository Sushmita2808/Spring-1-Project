package com.shoppingcart.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.Customer;
import com.shoppingcart.app.repository.CustomerRepository;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		
		return customerRepository.findAll();
	}

	@Override
	public MessageResponse save(Customer customer) {
		Customer newcustomer = new Customer();
		newcustomer.setCustomerName(customer.getCustomerName());
		newcustomer.setContactLastName(customer.getContactLastName());
		newcustomer.setContactFirstName(customer.getContactFirstName());
		newcustomer.setPhone(customer.getPhone());
		newcustomer.setAddressLine1(customer.getAddressLine1());
		newcustomer.setAddressLine2(customer.getAddressLine2());
		newcustomer.setCity(customer.getCity());
		newcustomer.setState(customer.getState());
		newcustomer.setPostalCode(customer.getPostalCode());
		newcustomer.setCountry(customer.getCountry());
		newcustomer.setSalesRepEmployeeNumber(customer.getSalesRepEmployeeNumber());
		newcustomer.setCreditLimit(customer.getCreditLimit());
		customerRepository.save(newcustomer);
		
		return new MessageResponse("New Customer record created successfully");

	}

	@Override
	public Optional<Customer> getById(long id)   {
		return customerRepository.findById(id);
	}	
	@Override
	public List<Customer> sortedByName(Customer customerdetails) {
		
		return customerRepository.findAllSortedByName();
	}

	@Override
	public List<Customer> getByLastName(String contactLastName) {
		
		return customerRepository.findByLastname(contactLastName);
	}
	
	
	@Override
	public List<Customer> paging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Customer> list =customerRepository.findCustomers(pageable);
		return list;
	}

	@Override
	public Iterable<Customer> sorting(Customer customerdetails) {
		String sortBy = "contact_first_name";
		List<Customer> list = (List<Customer>) customerRepository.sortCustomer(Sort.by(Sort.Direction.DESC,sortBy));
		return list;
	}

	@Override
	public Customer update(Customer customer) {
	            
	        return customerRepository.save(customer);
	    }
		
	@Override
	public MessageResponse deleteById(long id) {
		 customerRepository.findById(id);
		 
		 customerRepository.deleteById(id);
			 
		 return new MessageResponse("Customer record deleted successfully");

		 }

	
	}