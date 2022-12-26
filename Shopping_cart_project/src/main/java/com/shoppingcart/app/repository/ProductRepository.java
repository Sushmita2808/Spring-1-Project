package com.shoppingcart.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shoppingcart.app.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/*@Query(value = "SELECT p FROM Product p WHERE p.productName =?1")
	List<Product> findByProductName(String productName);*/
	
	@Query(value = "SELECT * FROM Products  WHERE Product_Name = ?",nativeQuery=true)
	List<Product> findByProductName(String productName);
	
	
	@Query(value = "SELECT p FROM Product p ORDER BY buyPrice")
	public List<Product> findAllSortedByPrice();		  
	   
	/*@Query(value = "SELECT p FROM Product p ORDER BY productName")
	public List<Product> findAllSortedByName();*/
	   
	@Query("from Product" )
	List<Product> findProducts(Pageable pageable);
	
	@Query("from Product" )
	public Iterable<Product> sortProduct(Sort sort);
	

} 