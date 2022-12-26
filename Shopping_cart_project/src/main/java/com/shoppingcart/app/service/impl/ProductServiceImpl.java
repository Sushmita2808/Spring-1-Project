package com.shoppingcart.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.Product;
import com.shoppingcart.app.repository.ProductRepository;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAll() {
		
		return productRepository.findAll();
	}

	@Override
	public MessageResponse save(Product product) {
		Product newProduct = new Product();
		newProduct.setProductName(product.getProductName());
		newProduct.setProductScale(product.getProductScale());
		newProduct.setProductVendor(product.getProductVendor());
		newProduct.setProductDescription(product.getProductDescription());
		newProduct.setQuantityInStock(product.getQuantityInStock());
		newProduct.setBuyPrice(product.getBuyPrice());
		newProduct.setMsrp(product.getMsrp());
		productRepository.save(newProduct);
		
		return new MessageResponse("New Product record created successfully");

		}
	@Override
	public Optional<Product> getById(long id) {
		return productRepository.findById(id);
		
		}


	@Override
	public List<Product> sortedByPrice(Product product) {
		return productRepository.findAllSortedByPrice();
	}

	@Override
	public List<Product> getByName(String productName) {
		return productRepository.findByProductName(productName);
	}
	
	@Override
	public List<Product> paging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Product> list = productRepository.findProducts(pageable);
		return list;
	}


	@Override
	public Iterable<Product> sorting(Product product) {
		String sortBy = "Product_Name";
		List<Product> list = (List<Product>)  productRepository.sortProduct(Sort.by(Sort.Direction.DESC,sortBy));
		return list;
	}

	@Override
	public Product update(Product product) {
		return productRepository.save(product);
    }

	@Override
	public MessageResponse deleteById(long id) {
		productRepository.findById(id);
		 
		 productRepository.deleteById(id);
			 
		 return new MessageResponse("Product record deleted successfully");

		 }

	
	}