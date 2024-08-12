package com.wu.ecommerce.controllers;

import java.sql.SQLException;

import com.wu.ecommerce.dto.Users;
import com.wu.ecommerce.exception.InvalidOrderIdException;
import com.wu.ecommerce.exception.InvalidUserIdException;
import com.wu.ecommerce.repo.UserRepositoryImpl;
import com.wu.ecommerce.service.UserService;
import com.wu.ecommerce.service.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserService userService = UserServiceImpl.getInstance();
		try {
			Users user=userService.addUser(new Users("a", "b", "c", "d", "8", "f"));
		} catch (SQLException | InvalidUserIdException | InvalidOrderIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
