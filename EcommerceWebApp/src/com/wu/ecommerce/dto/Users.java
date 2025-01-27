package com.wu.ecommerce.dto;

import com.wu.ecommerce.exception.InvalidOrderIdException;
import com.wu.ecommerce.exception.InvalidUserIdException;

public class Users {
	private String firstName;
	private String lastName;
	private String contact;
	
	private String address;
	private String userId;
	private String orderId;
	public Users(String firstName, String lastName, String contact, String address, String userId, String orderId) throws InvalidUserIdException, InvalidOrderIdException {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.address = address;
		this.setUserId(userId);
		this.setOrderId(orderId);
	}
	public Users() {
		// TODO Auto-generated constructor stub
	}
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getContact() {
		return contact;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) throws InvalidUserIdException {
		if(userId==null || userId.length()==0) {
			throw new InvalidUserIdException("Invalid User Id");
		}
		this.userId = userId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) throws InvalidOrderIdException {
		if(orderId==null || orderId.length()==0) {
			throw new InvalidOrderIdException("Invalid User Id");
		}
		this.orderId = orderId;
	}
	
	
	

}
