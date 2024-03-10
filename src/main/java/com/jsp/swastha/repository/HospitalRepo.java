package com.jsp.swastha.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.swastha.dto.Hospital;

public interface HospitalRepo extends JpaRepository<Hospital,  String>{
	public Hospital findByEmail(String email);
}
