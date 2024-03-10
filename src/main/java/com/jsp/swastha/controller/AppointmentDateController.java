package com.jsp.swastha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.swastha.dto.AppointmentDate;
import com.jsp.swastha.service.AppointmentDateService;
import com.jsp.swastha.util.ResponceStructure;

import io.swagger.annotations.ApiOperation;
@ApiOperation(value="APPOINTMENTDATE")
@RestController
public class AppointmentDateController {
	@Autowired
	AppointmentDateService appointmentDateService;
	@PostMapping("/date")
	public ResponseEntity<ResponceStructure<AppointmentDate>> saveSlot(@RequestParam String user_id, @RequestParam String specialist_id, @RequestBody AppointmentDate appointmentDate){
		return appointmentDateService.bookingSlot(user_id, specialist_id, appointmentDate);
	}

}
