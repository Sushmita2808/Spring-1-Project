package com.shoppingcart.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.shoppingcart.app.model.Payment;
import com.shoppingcart.app.repository.PaymentRepository;
import com.shoppingcart.app.response.MessageResponse;
import com.shoppingcart.app.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;


	@Override
	public List<Payment> findAll() {
		return paymentRepository.findAll();
	}

	@Override
	public MessageResponse save(Payment payment) {
		Payment  newPayment  = new Payment ();
		newPayment.setPaymentDate(payment.getPaymentDate());
		newPayment.setAmount(payment.getAmount());
		paymentRepository.save(newPayment );
		
		return new MessageResponse("New Payment  record created successfully");

	}

	@Override
	public Optional<Payment> getById(long id) {
		return paymentRepository.findById(id);
		}

	@Override
	public List<Payment> sortedByAmount(Payment payment) {
		
		return paymentRepository.findAllSortedByAmount();
	}

	@Override
	public List<Payment> paging() {
		Pageable pageable = PageRequest.of(0, 2);
		List<Payment> list = paymentRepository.findPayments(pageable);
		return list;
	} 
	@Override
	public Iterable<Payment> sorting(Payment payment) {
		String sortBy = "payment_Date";
		List<Payment> list = (List<Payment>) paymentRepository.sortPayment(Sort.by(Sort.Direction.DESC,sortBy));
		return list;
	}
	@Override
	public Payment update(Payment payment) {
		
		return paymentRepository.save(payment);
	}

	@Override
	public MessageResponse deleteById(long id) {
		paymentRepository.findById(id);
		 
		paymentRepository.deleteById(id);
			 
		return new MessageResponse("Payment record deleted successfully");

		 }

	
	}