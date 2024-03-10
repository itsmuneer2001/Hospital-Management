package com.jsp.swastha.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.jsp.swastha.dto.User;


public interface UserRepository extends JpaRepository<User, String>{
//	@Query("select a from  User a where a.email=?l")
	public User findByEmail(String email);
	
	@Query("select a from User a where a.bloodGroup=?1 and a.availability=''")
	public List<User> findByBloodGroup(String bloodGroup);
}
