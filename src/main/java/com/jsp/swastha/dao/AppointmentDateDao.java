package com.jsp.swastha.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.swastha.dto.AppointmentDate;
import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.dto.User;
import com.jsp.swastha.repository.AppointmentDateRepo;
 
@Repository
public class AppointmentDateDao {
	@Autowired
	AppointmentDateRepo appointmentDateRepo;
	
	public User findByUserId(String id) {
		return appointmentDateRepo.fetchByUserId(id);
	}
	public Specialist findBySpecialistId(String id) {
		return appointmentDateRepo.fetchBySpecialistId(id);
	}
	public AppointmentDate saveAppointment(AppointmentDate appointmentDate) {
		return appointmentDateRepo.save(appointmentDate);
	}
	
}
