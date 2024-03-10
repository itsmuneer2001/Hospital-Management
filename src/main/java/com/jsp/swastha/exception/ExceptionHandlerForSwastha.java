package com.jsp.swastha.exception;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.swastha.dto.User;
import com.jsp.swastha.util.ResponceStructure;

@ControllerAdvice
public class ExceptionHandlerForSwastha extends ResponseEntityExceptionHandler {
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ResponceStructure<String>> doublicateEmail(SQLIntegrityConstraintViolationException ex) {
		ResponceStructure<String> responceStructure = new ResponceStructure<>();
		responceStructure.setMessage(ex.getMessage());
		responceStructure.setStatus(HttpStatus.BAD_REQUEST.value());
		responceStructure.setData("dont insert dublicate email");
		return new ResponseEntity<ResponceStructure<String>>(responceStructure, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Email_Wrong.class)
	public ResponseEntity<ResponceStructure<String>> emailNotFound(Email_Wrong email_Wrong) {
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setMessage(email_Wrong.getMessage());
		structure.setData("email not exist");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(Password_Wrong.class)
	public ResponseEntity<ResponceStructure<String>> passwordWorng(Password_Wrong password_Wrong) {
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setMessage(password_Wrong.getMessage());
		structure.setData("Password incorrect");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(BloodGroup_Excep.class)
	public ResponseEntity<ResponceStructure<String>> bloodGroupWorng(BloodGroup_Excep bloodGroup_Excep) {
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setMessage(bloodGroup_Excep.getMessage());
		structure.setData("BloodGroup incorrect");
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ObjectNotFound.class)
	public ResponseEntity<ResponceStructure<String>> objectNotFound(ObjectNotFound objectNotFound) {
		ResponceStructure<String> structure = new ResponceStructure<>();
		structure.setMessage(objectNotFound.getMessage());
		structure.setData("not found");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponceStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(SlotTimeExist.class)
	public ResponseEntity<ResponceStructure<String>> slotTimeBooked(SlotTimeExist slotTimeExist){
		ResponceStructure<String> structure=new ResponceStructure<>();
		structure.setData("On this time slot booked");
		structure.setMessage(slotTimeExist.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponceStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmailOrPassContEmpty.class)
	public ResponseEntity<ResponceStructure<String>> slotTimeBooked(EmailOrPassContEmpty emailOrPassContEmpty){
		ResponceStructure<String> structure=new ResponceStructure<>();
		structure.setData("email and password cont empty");
		structure.setMessage(emailOrPassContEmpty.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<ResponceStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}

}
