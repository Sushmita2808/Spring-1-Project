package com.shoppingcart.app;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.app.model.Office;
import com.shoppingcart.app.repository.OfficeRepository;
import com.shoppingcart.app.service.OfficeService;

@SpringBootTest
public class OfficeTest {
	
	@Autowired
	private  OfficeService  officeService;
	
	@MockBean
	private  OfficeRepository  officeRepository;
	
	@Test
	@Order(1)
	@DisplayName(" Testing for creating Office record  ")
	public void  createOffice() {
		Office office = new Office();
		office.setOfficeCode(1L);
		office.setCity("Ranchi");
		office.setPhone("987656444");
		office.setAddressLine1("Main Road");
		office.setAddressLine2("Hinoo");
		office.setState("Jharkhand");
		office.setCountry("India");
		office.setPostalCode(83410);
		office.setTerritory("Pvt Area");
	
		Mockito.when(officeRepository.save(office))
		.thenReturn(office);
		
		assertThat(officeService.save(office))
		.isNotNull();
		
		}
	
	@Test
	@Order(2)
	@DisplayName(" Testing for getting Office record  by Id ")
	public void  getById() {
		Office office = new Office();
		office.setOfficeCode(1L);
		office.setCity("Ranchi");
		office.setPhone("987656444");
		office.setAddressLine1("Main Road");
		office.setAddressLine2("Hinoo");
		office.setState("Jharkhand");
		office.setCountry("India");
		office.setPostalCode(83410);
		office.setTerritory("Pvt Area");
	
		Mockito.when(officeRepository.save(office))
		.thenReturn(office);
		
		assertThat(officeService.getById(1L))
		.isNull();
		
		}
	
	@Test
	@Order(3)
	@DisplayName(" Testing for sorting Office record  by state ")
	public void  sortByState() {
		Office office = new Office();
		office.setOfficeCode(1L);
		office.setCity("Ranchi");
		office.setPhone("987656444");
		office.setAddressLine1("Main Road");
		office.setAddressLine2("Hinoo");
		office.setState("Jharkhand");
		office.setCountry("India");
		office.setPostalCode(83410);
		office.setTerritory("Pvt Area");
	
		Mockito.when(officeRepository.save(office))
		.thenReturn(office);
		
		assertThat(officeService.sortedByState(office))
		.isNotNull();
		
		}
	
	@Test
	@Order(4)
	@DisplayName(" Testing for paging ")
	public void  paging() {
		
		Office office = new Office();
		office.setOfficeCode(1L);
		office.setCity("Ranchi");
		office.setPhone("987656444");
		office.setAddressLine1("Main Road");
		office.setAddressLine2("Hinoo");
		office.setState("Jharkhand");
		office.setCountry("India");
		office.setPostalCode(83410);
		office.setTerritory("Pvt Area");
	
		Mockito.when(officeRepository.save(office))
		.thenReturn(office);
		
		assertThat(officeService.paging())
		.isNotNull();
		
		}
	
	@Test
	@Order(5)
	@DisplayName(" Testing for sorting ")
	public void  sorting() {
		
		Office office = new Office();
		office.setOfficeCode(1L);
		office.setCity("Ranchi");
		office.setPhone("987656444");
		office.setAddressLine1("Main Road");
		office.setAddressLine2("Hinoo");
		office.setState("Jharkhand");
		office.setCountry("India");
		office.setPostalCode(83410);
		office.setTerritory("Pvt Area");
	
		Mockito.when(officeRepository.save(office))
		.thenReturn(office);
		
		assertThat(officeService.sorting(office))
		.isNotNull();
		
		}

}
