package com.monocept.exception;

public class DuplicateProduct extends RuntimeException{
	
	public String getMessage() {
		return  "duplicate products are there";
	}

}
