package com.jsp.swastha.exception;

public class Password_Wrong extends RuntimeException{
	private String message="Enter currect password";

	public void setMessage(String message) {
		this.message = message;
	}
	public Password_Wrong() {
		super();
	}

}
