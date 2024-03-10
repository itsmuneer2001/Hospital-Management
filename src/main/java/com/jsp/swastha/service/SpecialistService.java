package com.jsp.swastha.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.swastha.dao.SpecitilistDao;
import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.exception.Email_Wrong;
import com.jsp.swastha.exception.ObjectNotFound;
import com.jsp.swastha.exception.Password_Wrong;
import com.jsp.swastha.util.ResponceStructure;
@Service
public class SpecialistService {
	@Autowired
	SpecitilistDao specitilistDao;
	@Autowired
	JavaMailSender javaMailSender;
	ResponceStructure<Specialist> structure=new ResponceStructure<>();
	public ResponseEntity<ResponceStructure<Specialist>> saveSpecialist(Specialist specialist){
		ResponceStructure  responceStructure=new ResponceStructure<>();
		responceStructure.setData(specitilistDao.saveSpecialist(specialist));
		responceStructure.setMessage("data saved succussfull");
		responceStructure.setStatus(HttpStatus.CREATED.value());
		
		SimpleMailMessage message=new SimpleMailMessage();		  
//        message.setFrom("itsmuneer2001gmail.com");
        message.setText("text");
        message.setTo(specialist.getEmail());
        message.setSubject("Hello , "+specialist.getName()+"\n"  
        		+ "Welcome! We’re excited that you're exploring careers at Swastha and that you've created your account. Kindly login into your account ."); 
        javaMailSender.send(message);
		
		return new ResponseEntity<ResponceStructure<Specialist>>(responceStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponceStructure<Specialist>> loginSpecialist(String email, String password) {
		ResponceStructure  responceStructure=new ResponceStructure<>();
		Specialist specialist_dataBase = specitilistDao.loginSpecialist(email);
		if (specialist_dataBase != null) {
			if (specialist_dataBase.getPassword().equals(password)) {
				responceStructure.setData(specialist_dataBase);
				responceStructure.setMessage("login successfull");
				responceStructure.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponceStructure<Specialist>>(responceStructure, HttpStatus.FOUND);
			}
			throw new Password_Wrong();
		}
		throw new Email_Wrong();
	}
	
	public ResponseEntity<ResponceStructure<Integer>> otpSend(String email){
		Specialist specialist_dataBase=specitilistDao.otpSend(email);
		if(specialist_dataBase!=null) {
			Random random=new Random();
			int randomNumber=random.nextInt(90000);
			ResponceStructure<Integer> structure=new ResponceStructure<>();
			structure.setData(randomNumber);
			structure.setMessage("Login succsfull");
			structure.setStatus(HttpStatus.CREATED.value());
			SimpleMailMessage message=new SimpleMailMessage();
			message.setFrom("itsmuneer2001@gmail.com");
			message.setSubject("Your OTP is "+randomNumber+". Please \n verify your email address");
			message.setTo(email);
			message.setText("Hi, \n  To proceed further with your application to swastha,please use the below OTP. \n"+randomNumber+"\n Regards \n Swastha");
			javaMailSender.send(message);
			return new ResponseEntity<ResponceStructure<Integer>>(structure,HttpStatus.CREATED);			
		}
		//throw exception here 
		throw new Email_Wrong();
	}
	public ResponseEntity<ResponceStructure<Specialist>> updateSpecialist(Specialist specialist){
		Specialist db=specitilistDao.updateSpecialist(specialist);
		if(db!=null) {
		structure.setData(specitilistDao.updateSpecialist(specialist));
		structure.setMessage("update succussfull");
		structure.setStatus(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponceStructure<Specialist>>(structure,HttpStatus.FOUND);
		}
		throw new  ObjectNotFound();
	}
	public ResponseEntity<ResponceStructure<Specialist>> deleteSpecialist(String id){
		Specialist specialist_dataBase=specitilistDao.deleteSpecialist(id);
		if(specialist_dataBase!=null) {
			structure.setData(specialist_dataBase);
			structure.setMessage("Delete Succsfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponceStructure<Specialist>>(structure,HttpStatus.FOUND);
		}
			//throw here exception 
		throw new  ObjectNotFound();
	}
	public ResponseEntity<ResponceStructure<Specialist>> getByIdSpecialist(String id){
		Specialist db=specitilistDao.getByIdSpecialist(id);
		
		if(db!=null) {
			structure.setData(db);
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("data fetched succssfull");
			return new ResponseEntity<ResponceStructure<Specialist>>(structure,HttpStatus.FOUND);
			
		}
		//throw exception here
		throw new  ObjectNotFound();
	}
	public ResponseEntity<ResponceStructure<List<Specialist>>> getByName(String name){
		ResponceStructure<List<Specialist>> structure=new ResponceStructure<>();
		List<Specialist> db=specitilistDao.getByName(name);
		if(db!=null) {
			structure.setData(db);
			structure.setMessage("data fetched succsfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponceStructure<List<Specialist>>>(structure,HttpStatus.FOUND);
		
		}
		//throw exception
		throw new  ObjectNotFound();
	}
	public ResponseEntity<ResponceStructure<List<Specialist>>> getByExperi(int id){
		ResponceStructure<List<Specialist>> structure=new ResponceStructure<>();
		List<Specialist> db=specitilistDao.getByExperi(id);
		if(db!=null) {
			structure.setData(db);
			structure.setMessage("data fetched succsfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponceStructure<List<Specialist>>>(structure,HttpStatus.FOUND);
		
		}
		//throw exception
		throw new  ObjectNotFound();
	}
	
	public ResponseEntity<ResponceStructure<List<Specialist>>> getBySpeciali(String specilizes){
		ResponceStructure<List<Specialist>> structure=new ResponceStructure<>();
		List<Specialist> db=specitilistDao.getBySpecilizes(specilizes);
		if(db!=null) {
			structure.setData(db);
			structure.setMessage("data fetched succsfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponceStructure<List<Specialist>>>(structure,HttpStatus.FOUND);
		
		}
		//throw exception
		throw new  ObjectNotFound();
	}
	public ResponseEntity<ResponceStructure<List<Specialist>>> getAll(){
		List<Specialist> list=specitilistDao.getAll();
		ResponceStructure<List<Specialist>> structure=new ResponceStructure<>();
		if(list!=null) {
			structure.setData(list);
			structure.setMessage("data fetched succsfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponceStructure<List<Specialist>>>(structure,HttpStatus.FOUND);
		}
		//throw exception here
		throw new  ObjectNotFound();
	}

}
