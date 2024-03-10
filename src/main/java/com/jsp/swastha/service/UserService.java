package com.jsp.swastha.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


import com.jsp.swastha.dao.UserDao;
import com.jsp.swastha.dto.User;
import com.jsp.swastha.exception.BloodGroup_Excep;
import com.jsp.swastha.exception.EmailOrPassContEmpty;
import com.jsp.swastha.exception.Email_Wrong;
import com.jsp.swastha.exception.ObjectNotFound;
import com.jsp.swastha.exception.Password_Wrong;
import com.jsp.swastha.util.ResponceStructure;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	@Autowired
	JavaMailSender javaMailSender;
	
	ResponceStructure<User> responceStructure = new ResponceStructure<>();

	public ResponseEntity<ResponceStructure<User>> saveUser(User user) {
		if(user.getEmail()!=null && user.getPassword()!=null) {
		responceStructure.setData(userDao.saveUser(user));
		responceStructure.setMessage(" saved sussfully");
		responceStructure.setStatus(HttpStatus.CREATED.value());
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("itsmuneer2001gmail.com");
		message.setText("text");
		message.setTo(user.getEmail());
		message.setSubject("Hello , " + user.getFirstName() 
				+ "\n   Welcome! We’re excited that you're exploring careers at Swatha and that you've created your account. Kindly login into your account .");
		javaMailSender.send(message);
		}
		else {
			throw new EmailOrPassContEmpty();
		}
		return new ResponseEntity<ResponceStructure<User>>(responceStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponceStructure<User>> loginUser(String email, String password) {
		User user_dataBase = userDao.loginUser(email);
		if (user_dataBase != null) {
			if (user_dataBase.getPassword().equals(password)) {
				responceStructure.setData(user_dataBase);
				responceStructure.setMessage("login successfull");
				responceStructure.setStatus(HttpStatus.FOUND.value());
				return new ResponseEntity<ResponceStructure<User>>(responceStructure, HttpStatus.FOUND);
			}
			throw new Password_Wrong();
		}
		throw new Email_Wrong();
	}

	public ResponseEntity<ResponceStructure<Integer>> otpSend(String email) {
		User user_dataBase = userDao.otpSend(email);
		if (user_dataBase != null) {
			Random random = new Random();
			int randomNumber = random.nextInt(90000);
			ResponceStructure<Integer> structure = new ResponceStructure<>();
			structure.setData(randomNumber);
			structure.setMessage("Login succsfull");
			structure.setStatus(HttpStatus.CREATED.value());
			SimpleMailMessage message = new SimpleMailMessage();
//			message.setFrom("itsmuneer2001@gmail.com");
			message.setSubject("Your OTP is " + randomNumber + ". Please \n verify your email address");
			message.setText("Hi, \n  To proceed further with your application to swastha,please use the below OTP. \n"
					+ randomNumber + "\n Regards \n Swastha");
			message.setTo(email);
			javaMailSender.send(message);
			return new ResponseEntity<ResponceStructure<Integer>>(structure, HttpStatus.CREATED);
		}

		// throw exception here
		throw new Email_Wrong();

	}

	public ResponseEntity<ResponceStructure<List<User>>> fetchByBloodGroup(String bloodGroup) {
		List<User> list_user = userDao.fetchByBloodGroup(bloodGroup);
		if (list_user != null) {
			ResponceStructure<List<User>> responceStructure1 = new ResponceStructure<>();
			responceStructure1.setData(list_user);
			responceStructure1.setMessage("fetched successfull");
			responceStructure1.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponceStructure<List<User>>>(responceStructure1, HttpStatus.FOUND);
		} else {
			throw new BloodGroup_Excep();
		}
		// throw exception here

	}

	public ResponseEntity<ResponceStructure<User>> updateUser(User user) {
		User db = userDao.updateUser(user);
		if (db != null) {

			responceStructure.setData(userDao.updateUser(user));
			responceStructure.setMessage("update succussfull");
			responceStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponceStructure<User>>(responceStructure, HttpStatus.FOUND);
		}
		throw new  ObjectNotFound();
	}

	public ResponseEntity<ResponceStructure<User>> deleteUser(String id) {
		User db = userDao.deleteUser(id);
		if (db != null) {
			responceStructure.setData(db);
			responceStructure.setMessage("Delete Succsfull");
			responceStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponceStructure<User>>(responceStructure, HttpStatus.FOUND);
		}
		// throw here exception
		throw new  ObjectNotFound();
	}

	public ResponseEntity<ResponceStructure<User>> getByIdUser(String id) {
		User db = userDao.getByIdUser(id);
		if (db != null) {
			responceStructure.setData(db);
			responceStructure.setStatus(HttpStatus.FOUND.value());
			responceStructure.setMessage("data fetched succssfull");
			return new ResponseEntity<ResponceStructure<User>>(responceStructure, HttpStatus.FOUND);

		}
		// throw exception here
		throw new  ObjectNotFound();
	}
	
	public ResponseEntity<ResponceStructure<List<User>>> getAll() {

		ResponceStructure<List<User>> structure = new ResponceStructure<>();

		List<User> list = userDao.getAll();
		if (list != null) {
			structure.setData(list);
			structure.setMessage("fetched successfull");
			structure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponceStructure<List<User>>>(structure, HttpStatus.FOUND);
		}
		// throw exception here
		throw new  ObjectNotFound();
	}
	
}
