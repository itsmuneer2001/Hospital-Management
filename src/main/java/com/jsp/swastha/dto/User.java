package com.jsp.swastha.dto;


import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.jsp.swastha.util.CustomerIdGenerator;

import lombok.Data;
@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@GenericGenerator(name = "user_seq", strategy = "com.jsp.swastha.util.CustomerIdGenerator", parameters = {
			@Parameter(name = CustomerIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomerIdGenerator.VALUE_PREFIX_PARAMETER, value = "User_"),
			@Parameter(name = CustomerIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String user_Id;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String password;
	private long phone;
	private String bloodGroup;
	private String availability;
	private String gender;
	@JoinColumn
	@OneToOne
	private Address address;

}
