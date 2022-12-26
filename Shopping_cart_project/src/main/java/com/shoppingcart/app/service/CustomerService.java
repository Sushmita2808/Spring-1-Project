package com.shoppingcart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shoppingcart.app.model.Customer;
import com.shoppingcart.app.response.MessageResponse;

@Component
public interface CustomerService {
	
	public List<Customer> findAll();
	
	public MessageResponse save(Customer customer);
	
	public Optional<Customer> getById(long id);
	
	public List<Customer> sortedByName(Customer customerdetails);
	
	public List<Customer> getByLastName(String contactLastName);
	
	public List<Customer> paging();
	
	public Iterable<Customer> sorting(Customer customerdetails);
	
	public MessageResponse deleteById(long id);
	
	Customer update(Customer customer) ;
	
}
