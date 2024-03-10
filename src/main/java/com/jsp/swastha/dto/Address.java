 package com.jsp.swastha.dto;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.jsp.swastha.util.CustomerIdGenerator;

import lombok.Data;
@Data
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	@GenericGenerator(name = "address_seq", strategy = "com.jsp.swastha.util.CustomerIdGenerator", parameters = {
			@Parameter(name = CustomerIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomerIdGenerator.VALUE_PREFIX_PARAMETER, value = "address_"),
			@Parameter(name = CustomerIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String address_Id;
	private String door_no;
	private String street;
	private String city;
	private String state;
	private int pincode;
	 @OneToOne(mappedBy = "address")
	private User user;
}
