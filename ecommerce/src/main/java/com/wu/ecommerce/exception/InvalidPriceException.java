package com.wu.ecommerce.exception;

public class InvalidPriceException extends Exception {
	public InvalidPriceException(String msg) {
		super(msg);
	}
	@Override
	public String toString() {
		return super.getMessage();
	}

}
