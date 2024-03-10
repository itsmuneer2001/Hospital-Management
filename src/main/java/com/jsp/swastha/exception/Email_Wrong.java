package com.jsp.swastha.exception;

public class Email_Wrong extends RuntimeException{
	private String message="Enter currect Email";

	public void setMessage(String message) {
		this.message = message;
	}
	public Email_Wrong() {
		super();
	}
}
