package com.shoppingcart.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.shoppingcart.app.model.ProductLine;
import com.shoppingcart.app.response.MessageResponse;

@Component
public interface ProductLineService {
	public List<ProductLine> findAll();
	
	public MessageResponse save(ProductLine productLine);
	
	public Optional<ProductLine> getById(long id);
	
	public List<ProductLine> sortedByDescription(ProductLine productLine);
	
	public List<ProductLine> paging();
	
	public Iterable<ProductLine> sorting(ProductLine productLine);
	
	ProductLine update(ProductLine productLine) ;
	
	public MessageResponse deleteById(long id);
	
	
}
