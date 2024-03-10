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

import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.dto.User;
import com.jsp.swastha.service.SpecialistService;
import com.jsp.swastha.util.ResponceStructure;

import io.swagger.annotations.ApiOperation;
@ApiOperation(value="SPECIALIST")
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE,RequestMethod.GET})
public class SpecialistController {
	@Autowired
	SpecialistService specialistService;

	@PostMapping("/savespecialist")
	public ResponseEntity<ResponceStructure<Specialist>> saveSpecialist(@RequestBody Specialist specialist) {
		return specialistService.saveSpecialist(specialist);
	}

	@GetMapping("/loginspecialist")
	public ResponseEntity<ResponceStructure<Specialist>> loginSpecialist(@RequestParam String email,
			@RequestParam String password) {
		return specialistService.loginSpecialist(email, password);

	}
	
	@GetMapping("/otpspecialist")
	public ResponseEntity<ResponceStructure<Integer>> otpSend(@RequestParam String email){
		return specialistService.otpSend(email);
	}
	
	@PutMapping("/updatespecialis")
	public ResponseEntity<ResponceStructure<Specialist>> updateSpecialist(@RequestBody Specialist specialist){
		return specialistService.updateSpecialist(specialist);
	}
	@DeleteMapping("/deletespecialist")
	public ResponseEntity<ResponceStructure<Specialist>> deleteSpecialist(@RequestParam String specialist_Id){
		return specialistService.deleteSpecialist(specialist_Id);
	}
	@GetMapping("/getbyidspecialist")
	public ResponseEntity<ResponceStructure<Specialist>> getByIdSpecialist(@RequestParam String specialist_Id){
		return specialistService.getByIdSpecialist(specialist_Id);
	}
	@GetMapping("getbynamespecialist")
	public ResponseEntity<ResponceStructure<List<Specialist>>> getByName(@RequestParam String name){
		return specialistService.getByName(name);
	}
	
	@GetMapping("/getbyexperispecialist")
	public ResponseEntity<ResponceStructure<List<Specialist>>> getByExperi(@RequestParam int experience){
		return specialistService.getByExperi(experience);
	}
	
	@GetMapping("/getbyspecialispecialist")
	public ResponseEntity<ResponceStructure<List<Specialist>>> getBySpeciali(@RequestParam String specilizes){
		return specialistService.getBySpeciali(specilizes);
	}
	@GetMapping("/listspecialist")
	public ResponseEntity<ResponceStructure<List<Specialist>>> getAll(){
		return specialistService.getAll();
	}
}
