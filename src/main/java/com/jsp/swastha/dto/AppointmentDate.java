package com.jsp.swastha.dto;



import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.jsp.swastha.util.CustomerIdGenerator;

import lombok.Data;

@Entity
@Data
public class AppointmentDate {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AppointmentDate_seq")
	@GenericGenerator(name = "AppointmentDate_seq", strategy = "com.jsp.swastha.util.CustomerIdGenerator", parameters = {
			@Parameter(name = CustomerIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = CustomerIdGenerator.VALUE_PREFIX_PARAMETER, value = "AppointmentDate_"),
			@Parameter(name = CustomerIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	private String appointmentDate_Id;
	private Date date;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<AppointmentTime> appointmentTimes;
	
}
