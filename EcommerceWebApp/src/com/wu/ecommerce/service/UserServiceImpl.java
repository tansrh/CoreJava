package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.Users;
import com.wu.ecommerce.exception.InvalidOrderIdException;
import com.wu.ecommerce.repo.OrderRepository;
import com.wu.ecommerce.repo.OrderRepositoryImpl;
import com.wu.ecommerce.repo.UserRepository;
import com.wu.ecommerce.repo.UserRepositoryImpl;

public class UserServiceImpl implements UserService {

	
	private UserRepository userRepository=UserRepositoryImpl.getInstance();
	private static UserService userService;
	public static UserService getInstance() {
		if(userService==null) {
			userService=new UserServiceImpl();
			
		}
		return userService;
	}
	@Override
	public Users addUser(Users user) throws SQLException {
		// TODO Auto-generated method stub
		return userRepository.addUser(user);
	}

	@Override
	public Users getUserByUserId(String Id) throws InvalidOrderIdException {
		// TODO Auto-generated method stub
		return userRepository.getUserByUserId(Id);
	}

	@Override
	public Optional<ArrayList<Users>> getUsers() {
		// TODO Auto-generated method stub
		return userRepository.getUsers();
	}

	@Override
	public Optional<ArrayList<Users>> getUsersByUserId(String userId) {
		// TODO Auto-generated method stub
		return userRepository.getUsersByUserId(userId);
	}

	@Override
	public String removeUserByUserId(String id) {
		// TODO Auto-generated method stub
		return userRepository.removeUserByUserId(id);
	}

	@Override
	public Users updateUserByUserId(String id, Users user) {
		// TODO Auto-generated method stub
		return userRepository.updateUserByUserId(id, user);
	}

}
