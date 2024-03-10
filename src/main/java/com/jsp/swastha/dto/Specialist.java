package com.jsp.swastha.dto;


import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.jsp.swastha.util.CustomerIdGenerator;

import lombok.Data;
@Data
@Entity
public class Specialist {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Specialist_seq")
	@GenericGenerator(name = "Specialist_seq", strategy = "com.jsp.swastha.util.CustomerIdGenerator", parameters = {
			@Parameter(name = CustomerIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomerIdGenerator.VALUE_PREFIX_PARAMETER, value = "Specialist_"),
			@Parameter(name = CustomerIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String specialist_Id;
	private String name;
	@Column(unique = true)
	private String email;
	private String password;
	private long phone;
	private String specilizes;
	private int experience;
	private int age;
	private String gender;
	private double fee;
	@JoinColumn
	@OneToOne
	private Address address;
	@JoinColumn
	@ManyToMany
	private List<User> user;
	@JoinColumn
	@ManyToOne
	private Hospital hospital;
	@OneToMany
	private List<AppointmentDate> appointmentDates;
}
