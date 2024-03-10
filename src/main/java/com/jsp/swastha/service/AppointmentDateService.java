package com.jsp.swastha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.swastha.dao.AppointmentDateDao;
import com.jsp.swastha.dao.PaymentDao;
import com.jsp.swastha.dto.AppointmentDate;
import com.jsp.swastha.dto.AppointmentTime;
import com.jsp.swastha.dto.Specialist;
import com.jsp.swastha.dto.User;
import com.jsp.swastha.exception.ObjectNotFound;
import com.jsp.swastha.exception.SlotTimeExist;
import com.jsp.swastha.util.ResponceStructure;

@Service
public class AppointmentDateService {
	@Autowired
	PaymentDao paymentDao;
	@Autowired
	AppointmentDateDao appointmentDateDao;
	@Autowired
	JavaMailSender javaMailSender;

	public ResponseEntity<ResponceStructure<AppointmentDate>> bookingSlot(String userId, String specialistId,
			AppointmentDate appointmentDate) {
		ResponceStructure<AppointmentDate> structure = new ResponceStructure<>();
		//checking user present or Not
		User db_user = appointmentDateDao.findByUserId(userId);
		if (db_user != null) {
			//checking specialist present or Not
			Specialist db_speciali = appointmentDateDao.findBySpecialistId(specialistId);
			if (db_speciali != null) {
				//saving appointment date
				AppointmentDate slot_Date = appointmentDateDao.saveAppointment(appointmentDate);
				structure.setData(slot_Date);
				structure.setMessage("Your Slot booked");
				structure.setStatus(HttpStatus.CREATED.value());
				if (slot_Date != null) {
					List<AppointmentTime> list = slot_Date.getAppointmentTimes();
					AppointmentDate db=appointmentDateDao.saveAppointment(appointmentDate);
					for (AppointmentTime appointmentTime : list) {
						
						if (appointmentTime != null && db!=appointmentDate.getAppointmentTimes()) {
							paymentDao.savePayment(appointmentTime.getPayment());
							SimpleMailMessage message = new SimpleMailMessage();
							message.setText(
									"SlotDate :" + slot_Date.getDate() + "  " + "SlotTime :" + appointmentTime.getTime());
							message.setTo(db_user.getEmail());
							message.setSubject("Your Slot booked");
							javaMailSender.send(message);
						}
						throw new SlotTimeExist();
					}
				}

				return new ResponseEntity<ResponceStructure<AppointmentDate>>(structure, HttpStatus.CREATED);
			}
			throw new ObjectNotFound();
		}
		throw new ObjectNotFound();
	}

}
