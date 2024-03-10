package com.jsp.swastha.exception;

public class BloodGroup_Excep extends RuntimeException{
	private String message="Enter currect BloodGroup";

	public void setMessage(String message) {
		this.message = message;
	}
	public BloodGroup_Excep() {
		// TODO Auto-generated constructor stub
	}

}
