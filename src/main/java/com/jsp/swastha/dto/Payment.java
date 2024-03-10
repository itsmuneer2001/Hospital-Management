package com.jsp.swastha.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.jsp.swastha.util.CustomerIdGenerator;

import lombok.Data;
@Data
@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Payment_seq")
	@GenericGenerator(name = "Payment_seq", strategy = "com.jsp.swastha.util.CustomerIdGenerator", parameters = {
			@Parameter(name = CustomerIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomerIdGenerator.VALUE_PREFIX_PARAMETER, value = "Payment_"),
			@Parameter(name = CustomerIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String payment_Id;
	private String mode;
	private double amount;

}
