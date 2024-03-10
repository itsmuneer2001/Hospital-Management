package com.jsp.swastha.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.swastha.dto.User;
import com.jsp.swastha.repository.UserRepository;
import com.jsp.swastha.util.AES_PasswordIncreiptAndDecript;


@Repository
public class UserDao {
	@Autowired
	UserRepository repository;

	public User saveUser(User user) {
		user.setPassword(AES_PasswordIncreiptAndDecript.encrypt(user.getPassword()));
		return repository.save(user);
	}

	public User loginUser(String email) {
		User db = repository.findByEmail(email);
		if (db != null) {
			return db;
		}
		return null;
	}

	public User otpSend(String email) {
		User db = repository.findByEmail(email);
		if (db != null) {
			return db;
		}
		return null;
	}

	public List<User> fetchByBloodGroup(String bloodGroup) {
		List<User> db = repository.findByBloodGroup(bloodGroup);
		if (db != null) {
			return db;
		}
		return null;
	}
	public User updateUser(User user) {
		if (repository.findById(user.getUser_Id()).isPresent()) {
			User db = repository.findById(user.getUser_Id()).get();
			user.setUser_Id(user.getUser_Id());
			if(user.getEmail()==null) {
				user.setEmail(db.getEmail());
			}
			if(user.getPassword()==null) {
				user.setPassword(db.getPassword());
			}
			return  repository.save(user);
		}
		return null;
	}
	public User deleteUser(String id) {
		Optional<User> db = repository.findById(id);

		if (db.isPresent()) {
			User userdb = db.get();

			repository.delete(userdb);
			return userdb;

		}else 
			return null;	
	}

	public User getByIdUser(String id) {
		if (repository.findById(id).isPresent()) {
			return repository.findById(id).get();
//			return repository.getById(id);
		}
		return null;
	}
	
	public List<User> getAll(){
		return repository.findAll();
	}
	
}
