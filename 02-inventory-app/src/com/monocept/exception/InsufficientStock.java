package com.monocept.exception;

public class InsufficientStock extends RuntimeException{
	public String getMessage()
	{
		return "Insufficent products";
		
	}
}
