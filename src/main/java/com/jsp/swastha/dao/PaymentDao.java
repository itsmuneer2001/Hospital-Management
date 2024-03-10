package com.jsp.swastha.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.swastha.dto.Payment;
import com.jsp.swastha.repository.PaymentRepo;

@Repository
public class PaymentDao {
	@Autowired
	PaymentRepo paymentRepo;
	public Payment savePayment(Payment payment) {
		return paymentRepo.save(payment);
				
	}
	

}
