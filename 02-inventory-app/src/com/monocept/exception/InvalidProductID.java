package com.monocept.exception;

public class InvalidProductID extends RuntimeException {
	public String getMessage() {
		return "Invalid products";
	}

}
