package com.shoppingcart.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.app.model.Order;
import com.shoppingcart.app.repository.OrderRepository;
import com.shoppingcart.app.service.OrderService;

@SpringBootTest
public class OrderTest {
	
	@Autowired
	private  OrderService  orderService;
	
	@MockBean
	private  OrderRepository  orderRepository;
	
	@Test
	@DisplayName(" Testing for creating Order record  ")
	public void  createOrder() {
		
		Order order = new Order();
		order.setOrderNumber(1L);
		order.setOrderDate(new Date(2022, 11, 10));
		order.setRequiredDate(new Date(2022, 11, 23));
		order.setShippedDate(new Date(2022, 11, 20));
		order.setStatus(true);
		order.setComments("Delivered");
		
		Mockito.when(orderRepository.save(order))
		.thenReturn(order);
		
		assertThat(orderService.save(order))
		.isNotNull();
		
		}
	
	@Test
	@DisplayName(" Testing for Order record by status is true ")
	public void  sortOrderByStatus() {
		
		Order order = new Order();
		order.setOrderNumber(1L);
		order.setOrderDate(new Date(2022, 11, 10));
		order.setRequiredDate(new Date(2022, 11, 23));
		order.setShippedDate(new Date(2022, 11, 20));
		order.setStatus(true);
		order.setComments("Delivered");
		
		Mockito.when(orderRepository.save(order))
		.thenReturn(order);
		
		assertThat(orderService.getByStatus(true))
		.isNotNull();
		
		}
	
	@Test
	@DisplayName(" Testing for deleting Order record ")
	public void  deleteOrder() {
		
		Order order = new Order();
		order.setOrderNumber(1L);
		order.setOrderDate(new Date(2022, 11, 10));
		order.setRequiredDate(new Date(2022, 11, 23));
		order.setShippedDate(new Date(2022, 11, 20));
		order.setStatus(true);
		order.setComments("Delivered");
		
		Mockito.when(orderRepository.save(order))
		.thenReturn(order);
		
		assertThat(orderService.deleteById(1L))
		.isNotNull();
		
		}
	
	@Test
	@DisplayName(" Testing for paging")
	public void  paging() {
		
		Order order = new Order();
		order.setOrderNumber(1L);
		order.setOrderDate(new Date(2022, 11, 10));
		order.setRequiredDate(new Date(2022, 11, 23));
		order.setShippedDate(new Date(2022, 11, 20));
		order.setStatus(true);
		order.setComments("Delivered");
		
		Mockito.when(orderRepository.save(order))
		.thenReturn(order);
		
		assertThat(orderService.paging())
		.isNotNull();
		
		}
	@Test
	@DisplayName(" Testing for sorting")
	public void  sorting() {
		
		Order order = new Order();
		order.setOrderNumber(1L);
		order.setOrderDate(new Date(2022, 11, 10));
		order.setRequiredDate(new Date(2022, 11, 23));
		order.setShippedDate(new Date(2022, 11, 20));
		order.setStatus(true);
		order.setComments("Delivered");
		
		Mockito.when(orderRepository.save(order))
		.thenReturn(order);
		
		assertThat(orderService.sorting(order))
		.isNotNull();
		
		}

}
