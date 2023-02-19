package com.java.hotelmanagement.exception;

public class BillNotFoundException extends RuntimeException {
	public BillNotFoundException(String message) {
		super(message);
	}
}
