package com.shoppingcart.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shoppingcart.app.model.Payment;


public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	@Query(value = "SELECT * FROM Payments ORDER BY Amount",nativeQuery=true)
	public List<Payment> findAllSortedByAmount();
	
	@Query("from Payment" )
	List<Payment> findPayments(Pageable pageable);
	
	@Query("from Payment" )
	public Iterable<Payment> sortPayment(Sort sort);
	

}