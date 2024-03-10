package com.jsp.swastha.dto;

import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.jsp.swastha.util.CustomerIdGenerator;

import lombok.Data;
@Data
@Entity
public class AppointmentTime {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AppointmentTime_seq")
	@GenericGenerator(name = "AppointmentTime_seq", strategy = "com.jsp.swastha.util.CustomerIdGenerator", parameters = {
			@Parameter(name = CustomerIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomerIdGenerator.VALUE_PREFIX_PARAMETER, value = "AppointTime_"),
			@Parameter(name = CustomerIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String appointmentTime_Id;
	private Time time;
	@OneToOne(cascade = CascadeType.ALL)
	private Payment payment;
	
}
