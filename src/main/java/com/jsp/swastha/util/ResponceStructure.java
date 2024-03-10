package com.jsp.swastha.util;

import com.jsp.swastha.dto.Specialist;

import lombok.Data;
@Data
public class ResponceStructure<T> {
	private String message;
	private int status;
	private T data;
	
	
}
