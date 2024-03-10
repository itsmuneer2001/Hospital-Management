package com.jsp.swastha.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.swastha.dao.HospitalDao;
import com.jsp.swastha.dto.Hospital;
import com.jsp.swastha.exception.ObjectNotFound;
import com.jsp.swastha.util.ResponceStructure;

@Service
public class HospitalService {
	@Autowired
	HospitalDao hospitalDao;
	@Autowired
	JavaMailSender javaMailSender;

	public ResponseEntity<ResponceStructure<Hospital>> saveHospital(Hospital hospital) {

		ResponceStructure responceStructure = new ResponceStructure<>();
		if (hospital.getSpecialists().equals("admin")) {
			responceStructure.setData(hospitalDao.saveHospital(hospital));
			responceStructure.setMessage("data saved succussfull");
			responceStructure.setStatus(HttpStatus.CREATED.value());

			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("itsmuneer2001gmail.com");
			message.setText("text");
			message.setTo(hospital.getEmail());
			message.setSubject("Hello , "
					+ "   Welcome! We’re excited that you're exploring careers at Sasken and that you've created your account. Kindly login into your account by clicking the link below.");
			javaMailSender.send(message);

			return new ResponseEntity<ResponceStructure<Hospital>>(responceStructure, HttpStatus.CREATED);
		}
		return null;
	}
	public ResponseEntity<ResponceStructure<Hospital>> getHospital(String id){
		ResponceStructure<Hospital> structure=new ResponceStructure<>();
		Hospital db=hospitalDao.getHospital(id);
		if(db!=null) {
			structure.setData(db);
			structure.setMessage("Data fetched succssfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponceStructure<Hospital>>(structure,HttpStatus.FOUND);
		}
		//throw exception
		throw new  ObjectNotFound();
	}
	public ResponseEntity<ResponceStructure<Hospital>> deleteHospital(String id){
		ResponceStructure<Hospital> structure=new ResponceStructure<>();
		Hospital db=hospitalDao.getHospital(id);
		if(db!=null) {
			structure.setData(db);
			structure.setMessage("Data deleted succssfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponceStructure<Hospital>>(structure,HttpStatus.FOUND);
		}
		//throw exception
		throw new  ObjectNotFound();
	}
	

}
