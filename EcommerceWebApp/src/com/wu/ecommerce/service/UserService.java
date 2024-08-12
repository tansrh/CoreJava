package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.Users;
import com.wu.ecommerce.exception.InvalidOrderIdException;

public interface UserService {
	public Users addUser(Users user) throws SQLException;
	public Users getUserByUserId(String Id) throws InvalidOrderIdException;
	public Optional<ArrayList<Users>> getUsers();
	public Optional<ArrayList<Users>> getUsersByUserId(String userId);
	public String removeUserByUserId(String id);
	public Users updateUserByUserId(String id, Users user);
	default void display() {
		System.out.println("hello");
	}
}
