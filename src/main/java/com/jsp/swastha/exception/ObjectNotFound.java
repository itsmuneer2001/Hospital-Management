package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class ObjectNotFound extends RuntimeException{
	private String message="Not found";
	public ObjectNotFound() {
		super();
	}

}
