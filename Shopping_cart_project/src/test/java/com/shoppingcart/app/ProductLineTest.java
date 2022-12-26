package com.shoppingcart.app;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.app.model.ProductLine;
import com.shoppingcart.app.repository.ProductLineRepository;
import com.shoppingcart.app.service.ProductLineService;

@SpringBootTest
public class ProductLineTest {
	
	@Autowired
	private ProductLineService productLineService;
	
	@MockBean
	private ProductLineRepository productLineRepository;
	
	@Test
	@Order(1)
	@DisplayName(" Testing for creating ProductLine  ")
	public void  createProductLine() {
		
		ProductLine productLine = new ProductLine();
		productLine.setProductLine(5L);
		productLine.setTextDescription("Soft and smooth");
		productLine.setHtmlDescription("<ol>Soft and smooth<ol>");
		productLine.setImage("Lotion.jpg");
		
		Mockito.when(productLineRepository.save(productLine))
		.thenReturn(productLine);
		
		assertThat(productLineService.save(productLine)).isNotNull();
		
	
		}
	
	@Test
	@Order(2)
	@DisplayName(" Testing for getting productLine by id   ")
	public void  getProductLinebyId() {
		
		ProductLine productLine = new ProductLine();
		productLine.setProductLine(5L);
		productLine.setTextDescription("Soft and smooth");
		productLine.setHtmlDescription("<ol>Soft and smooth<ol>");
		productLine.setImage("Lotion.jpg");
		
		Mockito.when(productLineRepository.save(productLine))
		.thenReturn(productLine);
		
		assertThat(productLineService.getById(6L))
		.isNull();
		
	
		}
	
	@Test
	@Order(3)
	@DisplayName(" Testing for deleteing by id   ")
	public void  deleteProductLinebyId() {
		
		ProductLine productLine = new ProductLine();
		productLine.setProductLine(5L);
		productLine.setTextDescription("Soft and smooth");
		productLine.setHtmlDescription("<ol>Soft and smooth<ol>");
		productLine.setImage("Lotion.jpg");
		
		Mockito.when(productLineRepository.save(productLine))
		.thenReturn(productLine);
		
		assertThat(productLineService.deleteById(5L))
		.isNotNull();
		
	
		}
	
	@Test
	@Order(4)
	@DisplayName(" Testing for paging   ")
	public void  paging() {
		
		ProductLine productLine = new ProductLine();
		productLine.setProductLine(5L);
		productLine.setTextDescription("Soft and smooth");
		productLine.setHtmlDescription("<ol>Soft and smooth<ol>");
		productLine.setImage("Lotion.jpg");
		
		Mockito.when(productLineRepository.save(productLine))
		.thenReturn(productLine);
		
		assertThat(productLineService.paging())
		.isNotNull();
		
	
		}
	
	@Test
	@Order(5)
	@DisplayName(" Testing for sorting ")
	public void  sorting() {
		
		ProductLine productLine = new ProductLine();
		productLine.setProductLine(5L);
		productLine.setTextDescription("Soft and smooth");
		productLine.setHtmlDescription("<ol>Soft and smooth<ol>");
		productLine.setImage("Lotion.jpg");
		
		Mockito.when(productLineRepository.save(productLine))
		.thenReturn(productLine);
		
		assertThat(productLineService.sorting(productLine))
		.isNotNull();
		
	
		}

}
