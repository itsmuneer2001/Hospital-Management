package com.jsp.swastha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.swastha.dto.Hospital;
import com.jsp.swastha.service.HospitalService;
import com.jsp.swastha.util.ResponceStructure;

import io.swagger.annotations.ApiOperation;
@ApiOperation(value="HOSPITAL")
@RestController
public class HospitalController {
	@Autowired
	HospitalService hospitalService;
	public ResponseEntity<ResponceStructure<Hospital>> saveHospital(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}
	
	public ResponseEntity<ResponceStructure<Hospital>> getHospital(@RequestParam String id){
		return hospitalService.getHospital(id);
	}
	
	public ResponseEntity<ResponceStructure<Hospital>> deleteHospital(@RequestParam String id){
		return hospitalService.deleteHospital(id);
	}
	
}
