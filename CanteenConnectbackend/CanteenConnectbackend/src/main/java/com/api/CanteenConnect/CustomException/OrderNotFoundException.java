package com.api.CanteenConnect.CustomException;

public class OrderNotFoundException extends RuntimeException {

	public OrderNotFoundException(String message) {
		super(message);
		
	}

}
