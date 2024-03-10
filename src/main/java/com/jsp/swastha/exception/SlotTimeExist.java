package com.jsp.swastha.exception;

import lombok.Data;

@Data
public class SlotTimeExist extends RuntimeException {
	private String message="Slot Time booked";
	public SlotTimeExist() {
		super();
	}

}
