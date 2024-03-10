package com.jsp.swastha.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.dto.User;
import com.jsp.swastha.repository.SpecitilistRepo;
@Repository
public class SpecitilistDao {
	@Autowired
	SpecitilistRepo specitilistRepo;
	public Specialist saveSpecialist(Specialist specialist) {
		return specitilistRepo.save(specialist);
	}
	public Specialist loginSpecialist(String email) {
		Specialist db = specitilistRepo.findByEmail(email);
		if (db != null) {
			return db;
		}
		return null;
	}
	
	public Specialist otpSend(String email) {
		Specialist db = specitilistRepo.findByEmail(email);
		if (db != null) {
			return db;
		}
		return null;
	}
	
	public Specialist updateSpecialist(Specialist specialist) {
		if (specitilistRepo.findById(specialist.getSpecialist_Id()).isPresent()) {
			Specialist db = specitilistRepo.findById(specialist.getSpecialist_Id()).get();
//			specialist.setSpecialist_Id(id);
			if(specialist.getEmail()==null) {
				specialist.setEmail(db.getEmail());
			}
			if(specialist.getPassword()==null) {
				specialist.setPassword(db.getPassword());
			}
			return  specitilistRepo.save(db);
		}
		return null;
		
	}
	public Specialist deleteSpecialist(String id) {
		Optional<Specialist> db = specitilistRepo.findById(id);
		if (db != null) {
			specitilistRepo.delete(db.get());
		}
		return db.get();
	}
	public Specialist getByIdSpecialist(String id) {
		if (specitilistRepo.findById(id).isPresent()) {
			return specitilistRepo.getById(id);
		}
		return null;
	}
	public List<Specialist> getByName(String name) {
		List<Specialist> db=specitilistRepo.fetchByName(name);
		if(db!=null) {
			return db;
		}
		return null;
	}
	 
	public List<Specialist> getByExperi(int expe) {
		List<Specialist> db= specitilistRepo.fetchByExperiance(expe);
		if(db!=null) {
			return db;
		}
		return null;
	
	}
	public List<Specialist> getBySpecilizes(String specilizes) {
		List<Specialist> db= specitilistRepo.fetchBySpecilizes(specilizes);
		if(db!=null) {
			return db;
		}
		return null;
	}
	public List<Specialist> getAll(){
	return 	specitilistRepo.findAll();
	}
	
}

