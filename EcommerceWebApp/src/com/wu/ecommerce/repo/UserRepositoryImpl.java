package com.wu.ecommerce.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.Order;
import com.wu.ecommerce.dto.Users;
import com.wu.ecommerce.exception.InvalidOrderIdException;
import com.wu.ecommerce.exception.InvalidUserIdException;
import com.wu.ecommerce.utils.DBUtils;

public class UserRepositoryImpl implements UserRepository{

	
	
	
	private static  UserRepository userRepository;
	private ArrayList<Users> users=new ArrayList<Users>();
	public static UserRepository getInstance() {
		if(userRepository==null) {
			userRepository=new UserRepositoryImpl();
		}
		return userRepository;
	}

	
	@Override
	public Users addUser(Users user) throws SQLException {
		// TODO Auto-generated method stub
		if(user==null) {
			return null;
		}
		String statement="insert into users (firstname, lastname, contact, address, userid, orderid) values(?, ?, ?, ?, ?, ?) ";
		Connection connection=null;
		try {
			connection = DBUtils.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement preparedStatement=connection.prepareStatement(statement);
		preparedStatement.setString(1, user.getFirstName());
		preparedStatement.setString(2, user.getLastName());
		preparedStatement.setString(3, user.getContact());
		preparedStatement.setString(4, user.getAddress());
		preparedStatement.setString(5, user.getUserId());
		preparedStatement.setString(6, user.getOrderId());
		int res=preparedStatement.executeUpdate();
		if(res>0) {
		return user;	
		}
		else {
			return null;
		}
	}

	@Override
	public Users getUserByUserId(String Id) throws InvalidOrderIdException {
		// TODO Auto-generated method stub
		String statement="select * from users where userid = ? ";
		Connection connection=null;
		try {
			connection = DBUtils.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(statement);
			preparedStatement.setString(1, Id);
			
			ResultSet res=preparedStatement.executeQuery();
			if(res.next()) {
				return (new Users(res.getString("firstname"), res.getString("lastname"), res.getString("contact"), res.getString("address"), res.getString("userid"), res.getString("orderid")));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidUserIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

	}

	@Override
	public Optional<ArrayList<Users>> getUsers() {
		// TODO Auto-generated method stub
		String statement="select * from users";
		Connection connection=null;
		ArrayList<Users>list=new ArrayList<Users>();
		try {
			connection = DBUtils.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(statement);
			
			ResultSet res=preparedStatement.executeQuery();
			while(res.next()) {
				list.add(new Users(res.getString("firstname"), res.getString("lastname"), res.getString("contact"), res.getString("address"), res.getString("userid"), res.getString("orderid")));
				 
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidUserIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidOrderIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return Optional.ofNullable(list);
	}

	@Override
	public Optional<ArrayList<Users>> getUsersByUserId(String userId) {
		// TODO Auto-generated method stub
		
		
		
		
		String statement="select * from users where userid = ? ";
		Connection connection=null;
		ArrayList<Users>list=new ArrayList<Users>();

		try {
			connection = DBUtils.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(statement);
			preparedStatement.setString(1,userId);
			
			ResultSet res=preparedStatement.executeQuery();
			while(res.next()) {
				list.add(new Users(res.getString("firstname"), res.getString("lastname"), res.getString("contact"), res.getString("address"), res.getString("userid"), res.getString("orderid")));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidUserIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidOrderIdException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return Optional.ofNullable(list);
	}

	@Override
	public String removeUserByUserId(String id) {
		// TODO Auto-generated method stub
		String statement="delete from users where userid = ? ";
		Connection connection=null;
		try {
			connection = DBUtils.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(statement);
			preparedStatement.setString(1, id);
			
			int res=preparedStatement.executeUpdate();
			System.out.println(res); 
			if(res>0) {
			
			return "Operation successful";
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return "Operation failed";
	}

	@Override
	public Users updateUserByUserId(String id, Users user) {
		// TODO Auto-generated method stub
		String statement="update users set firstname = ?, lastname = ?, contact = ?, address = ?, userid = ? where orderid = ? ";
		Connection connection=null;
		try {
			connection = DBUtils.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(statement);
			
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getContact());
			preparedStatement.setString(4,  user.getAddress());
			preparedStatement.setString(5,  user.getUserId());
			preparedStatement.setString(6, id);
			
			int res=preparedStatement.executeUpdate();
			if(res>0) {
			return user;
			}
			else {
				return null;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}

}
