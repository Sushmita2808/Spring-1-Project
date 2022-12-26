package com.shoppingcart.app.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shoppingcart.app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query(value = "SELECT * FROM orders WHERE Status=true",nativeQuery=true)
	public List<Order> findByTrueStatus();
	
	@Query("from Order" )
	List<Order> findOrders(Pageable pageable);
	
	@Query("from Order" )
	public Iterable<Order> sortOrder(Sort sort);
	


}
