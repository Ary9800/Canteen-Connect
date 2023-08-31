package com.api.CanteenConnect.CustomException;

public class FooditemNotFoundException extends RuntimeException {
	 public FooditemNotFoundException(String message) {
	        super(message);
	    }

}
