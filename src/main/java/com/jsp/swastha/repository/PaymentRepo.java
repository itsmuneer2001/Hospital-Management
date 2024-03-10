package com.jsp.swastha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.swastha.dto.Payment;

public interface PaymentRepo extends JpaRepository<Payment, String>{

}
