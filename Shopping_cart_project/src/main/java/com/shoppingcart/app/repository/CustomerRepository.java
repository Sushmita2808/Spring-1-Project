package com.shoppingcart.app.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shoppingcart.app.model.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	@Query(value = "SELECT c FROM Customer c ORDER BY customerName")
	public List<Customer> findAllSortedByName();
	
	@Query(value = "SELECT * FROM customers  where contact_last_name = ?",nativeQuery=true)
	public List<Customer> findByLastname(String contactLastName);
	
	@Query("from Customer" )
	public List<Customer> findCustomers(Pageable pageable);
	
	@Query("from Customer" )
	public Iterable<Customer> sortCustomer(Sort sort);
	
	
	
	
}
