package com.jsp.swastha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.swastha.dto.User;
import com.jsp.swastha.service.UserService;
import com.jsp.swastha.util.ResponceStructure;

import io.swagger.annotations.ApiOperation;
@ApiOperation(value = "USER")
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.DELETE,RequestMethod.GET,RequestMethod.PUT})
public class UserController {
	@Autowired
	UserService userService;
	@ApiOperation(value="user save")
	@PostMapping("/usersave")
	
	
	public ResponseEntity<ResponceStructure<User>> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	@GetMapping("/userlogin")
	public ResponseEntity<ResponceStructure<User>> loginUser(@RequestParam String email,@RequestParam String password ){
		return userService.loginUser(email,password);
	}
	@GetMapping("/otpuser")
	public ResponseEntity<ResponceStructure<Integer>> otpSend(@RequestParam String email){
		return userService.otpSend(email);
	}
	@GetMapping("/fetchbyblood")
	public ResponseEntity<ResponceStructure<List<User>>> fetchByBloodGroup(@RequestParam String bloodGroup){
		return userService.fetchByBloodGroup(bloodGroup);
	} 
	
	@PutMapping("/userupdate")
	public ResponseEntity<ResponceStructure<User>> updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}
	@DeleteMapping("/userdelete")
	public ResponseEntity<ResponceStructure<User>> deleteUser(@RequestParam String user_Id){
		return userService.deleteUser(user_Id);
	}
	@GetMapping("/usergetbyid")
	public ResponseEntity<ResponceStructure<User>> getByIdUser(@RequestParam String user_id){
		return userService.getByIdUser(user_id);
	}
	@GetMapping("/getalluser")
	public ResponseEntity<ResponceStructure<List<User>>> getAll(){
		return userService.getAll();
	}
}

