package com.shoppingcart.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.ProductLine;
import com.shoppingcart.app.repository.ProductLineRepository;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.ProductLineService;

@Service
public class ProductLineServiceImpl implements ProductLineService {
	
	@Autowired
	private ProductLineRepository productLineRepository;

	@Override
	public List<ProductLine> findAll() {
		
		return productLineRepository.findAll();
	}

	@Override
	public MessageResponse save(ProductLine productLine) {
		ProductLine newProductLine = new ProductLine();
		newProductLine.setTextDescription(productLine.getTextDescription());
		newProductLine.setHtmlDescription(productLine.getHtmlDescription());
		newProductLine.setImage(productLine.getImage());
		productLineRepository.save(newProductLine);
		
		return new MessageResponse("New ProductLine record created successfully");

	}

	@Override
	public Optional<ProductLine> getById(long id) {
		return productLineRepository.findById(id);
	}

	@Override
	public List<ProductLine> sortedByDescription(ProductLine productLine) {
		return productLineRepository.findAllSortedByDescription();
	}

	@Override
	public List<ProductLine> paging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<ProductLine> list = productLineRepository.findProductLines(pageable);
		return list;
	}


	@Override
	public Iterable<ProductLine> sorting(ProductLine productLine) {
		String sortBy = "Product_Line";
		List<ProductLine> list = (List<ProductLine>) productLineRepository.sortProductLine(Sort.by(Sort.Direction.DESC,sortBy));
		return list;
	}

	@Override
	public ProductLine update(ProductLine productLine) {
	       
        return productLineRepository.save(productLine);
    }
	

	@Override
	public MessageResponse deleteById(long id) {
		productLineRepository.findById(id);
		 
		productLineRepository.deleteById(id);
			 
		 return new MessageResponse("ProductLine record deleted successfully");

		 }

	
	}