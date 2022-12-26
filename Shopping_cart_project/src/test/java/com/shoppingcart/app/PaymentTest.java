package com.shoppingcart.app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shoppingcart.app.model.Payment;
import com.shoppingcart.app.repository.PaymentRepository;
import com.shoppingcart.app.service.PaymentService;


@SpringBootTest
public class PaymentTest {
	
	@Autowired
	private  PaymentService  paymentService;
	
	@MockBean
	private  PaymentRepository  paymentRepository;
	
	@Test
	@Order(1)
	@DisplayName(" Testing for creating Payment record  ")
	public void  createPayment() {
		
		Payment  payment  = new Payment ();
		payment.setCustomerNumber(1L);
		payment.setPaymentDate(new Date(2022, 11, 25));
		payment.setAmount(250.13);
		
		Mockito.when(paymentRepository.save(payment))
		.thenReturn( payment);
		
		assertThat(paymentService.save( payment))
		.isNotNull();
		
		}
	
	@Test
	@Order(2)
	@DisplayName(" Testing for getting Payment record by Id  ")
	public void  getById() {
		
		Payment  payment  = new Payment ();
		payment.setCustomerNumber(1L);
		payment.setPaymentDate(new Date(2022, 11, 25));
		payment.setAmount(250.13);
		
		Mockito.when(paymentRepository.save(payment))
		.thenReturn( payment);
		
		assertThat(paymentService.getById(1L))
		.isNull();
		
		}
	
	@Test
	@Order(3)
	@DisplayName(" Testing for paging ")
	public void  paging() {
		
		Payment  payment  = new Payment ();
		payment.setCustomerNumber(1L);
		payment.setPaymentDate(new Date(2022, 11, 25));
		payment.setAmount(250.13);
		
		Mockito.when(paymentRepository.save(payment))
		.thenReturn( payment);
		
		assertThat(paymentService.paging())
		.isNotNull();
		
		}
	
	@Test
	@Order(4)
	@DisplayName(" Testing for sorting")
	public void  sorting() {
		
		Payment  payment  = new Payment ();
		payment.setCustomerNumber(1L);
		payment.setPaymentDate(new Date(2022, 11, 25));
		payment.setAmount(250.13);
		
		Mockito.when(paymentRepository.save(payment))
		.thenReturn( payment);
		
		assertThat(paymentService.sorting(payment))
		.isNotNull();
		
		}
	
	@Test
	@Order(4)
	@DisplayName(" Testing for deleting by Payment record")
	public void  deleteById() {
		
		Payment  payment  = new Payment ();
		payment.setCustomerNumber(1L);
		payment.setPaymentDate(new Date(2022, 11, 25));
		payment.setAmount(250.13);
		
		Mockito.when(paymentRepository.save(payment))
		.thenReturn( payment);
		
		assertThat(paymentService.deleteById(1L))
		.isNotNull();
		
		}


}
