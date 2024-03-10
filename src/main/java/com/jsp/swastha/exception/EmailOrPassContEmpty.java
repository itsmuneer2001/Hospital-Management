package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class EmailOrPassContEmpty extends RuntimeException{
	private String message="Emain and password con't empty";
	public EmailOrPassContEmpty() {
		super();
	}

}