package com.wu.ecommerce.exception;

public class InvalidIDException extends Exception {

	public InvalidIDException(String msg) {
		super(msg);
	}
	@Override
	public String toString() {
		return super.getMessage();
	}
}
