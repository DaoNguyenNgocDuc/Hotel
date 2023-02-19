package com.java.hotelmanagement.exception;

public class RoomTypeNotFoundException extends RuntimeException {
	public RoomTypeNotFoundException(String message) {
		super(message);
	}
}
