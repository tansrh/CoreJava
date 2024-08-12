package com.wu.ecommerce.exception;

public class InvalidUserIdException extends Exception {

	
	public InvalidUserIdException(String msg) {
		super(msg);
	}
	@Override
	public String toString() {
		return super.getMessage();
	}

}
