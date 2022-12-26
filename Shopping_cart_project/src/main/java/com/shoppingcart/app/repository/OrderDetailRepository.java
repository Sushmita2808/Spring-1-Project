package com.shoppingcart.app.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shoppingcart.app.model.OrderDetail;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long>{
	
	@Query(value = "SELECT * FROM Orderdetails Where Price_Each > ?1",nativeQuery=true)
	public List<OrderDetail> findGreaterthanEqualByPrice(double priceEach);
	 
	@Query("from OrderDetail" )
	List<OrderDetail> findOrderDetails(Pageable pageable);
	
	@Query("from OrderDetail" )
	public Iterable<OrderDetail> sortOrderDetail(Sort sort);
	

}
