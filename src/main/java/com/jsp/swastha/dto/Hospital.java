package com.jsp.swastha.dto;


import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.jsp.swastha.util.CustomerIdGenerator;

import lombok.Data;
@Data
@Entity
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Hospital_seq")
	@GenericGenerator(name = "Hospital_seq", strategy = "com.jsp.swastha.util.CustomerIdGenerator", parameters = {
			@Parameter(name = CustomerIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomerIdGenerator.VALUE_PREFIX_PARAMETER, value = "Hospital_"),
			@Parameter(name = CustomerIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String hospital_Id;
	private String name;
	private String website;
	@Column(unique = true)
	private String email;
	private Long phone;
	@JoinColumn
	@OneToOne
	private Address address;
	@OneToMany(mappedBy = "hospital")
	private List<Specialist>specialists;

}
