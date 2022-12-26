package com.shoppingcart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shoppingcart.app.model.Order;
import com.shoppingcart.app.response.MessageResponse;

@Component
public interface OrderService {
	public List<Order> findAll();
	
	public MessageResponse save(Order order);
	
	public Optional<Order> getById(long id);
	
	public List<Order> getByStatus( boolean status);
	
	public List<Order> paging();
	
	public Iterable<Order> sorting(Order order);
	
	Order update(Order order) ;
	
	public MessageResponse deleteById(long id);
	
}
