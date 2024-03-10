package com.jsp.swastha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.swastha.dto.AppointmentDate;

import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.dto.User;


public interface AppointmentDateRepo extends JpaRepository<AppointmentDate, String>{
	@Query("select a from User a where a.id=?1")
	public User fetchByUserId(String id);
	
	@Query("select a from Specialist a where a.id=?1")
	public Specialist fetchBySpecialistId(String id);
}
