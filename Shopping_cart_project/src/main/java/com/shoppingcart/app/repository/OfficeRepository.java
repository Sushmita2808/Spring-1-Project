package com.shoppingcart.app.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shoppingcart.app.model.Office;

public interface OfficeRepository extends JpaRepository<Office, Long> {
	
	@Query(value = "SELECT  off FROM Office off ORDER BY state")
	public List<Office> findAllSortedByState();
	
	@Query(value="select * from Office  where City= ?", nativeQuery=true)
	public List<Office> findByCity(String city);
	
	
	@Query("from Office" )
	List<Office> findOffices(Pageable pageable);
	
	@Query("from Office" )
	public Iterable<Office> sortOffice(Sort sort);
	

}