package com.jsp.swastha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.swastha.dto.Specialist;


public interface SpecitilistRepo extends JpaRepository<Specialist, String>{
	
	public Specialist findByEmail(String email);
	
	@Query("select a from Specialist a where a.name=:name")
	public List<Specialist> fetchByName(String name);
	
	@Query("select a from Specialist a where a.experience=?1")
	public List<Specialist> fetchByExperiance(int expe);
	
	@Query("select a from Specialist a where a.specilizes=?1")
	public List<Specialist> fetchBySpecilizes(String specilizes);
}
