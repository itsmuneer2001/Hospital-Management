package com.jsp.swastha.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.swastha.dto.Hospital;
import com.jsp.swastha.repository.HospitalRepo;

@Repository
public class HospitalDao {
	@Autowired
	HospitalRepo hospitalRepo;
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}
	public Hospital getHospital(String id) {
		if(hospitalRepo.findById(id).isPresent()) {
			return hospitalRepo.findById(id).get();
		}
		return null;
	}
	public Hospital deleteHospital(String id) {
		Hospital db=hospitalRepo.getById(id);
		if(db!=null) {
			return db;
		}
		return null;
	}

}
