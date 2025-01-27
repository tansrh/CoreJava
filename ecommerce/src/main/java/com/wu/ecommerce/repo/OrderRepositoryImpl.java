package com.wu.ecommerce.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.wu.ecommerce.dto.Order;
import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.InvalidIDException;
import com.wu.ecommerce.exception.InvalidOrderIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.exception.InvalidUserIdException;
import com.wu.ecommerce.utils.DBUtils;

public class OrderRepositoryImpl implements OrderRepository {

	private static  OrderRepository orderRepository;
	private ArrayList<Order> orders=new ArrayList<Order>();
	public static OrderRepository getInstance() {
		if(orderRepository==null) {
			orderRepository=new OrderRepositoryImpl();
		}
		return orderRepository;
	}

	@Override
	public Order addOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		//orders.add(order);
		
		String statement="insert into orders (firstname, lastname, contact, address, userid, orderid) values(?, ?, ?, ?, ?, ?) ";
		Connection connection=null;
		try {
			connection = DBUtils.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement preparedStatement=connection.prepareStatement(statement);
		preparedStatement.setString(1, order.getFirstName());
		preparedStatement.setString(2, order.getLastName());
		preparedStatement.setString(3, order.getContact());
		preparedStatement.setString(4, order.getAddress());
		preparedStatement.setString(5, order.getUserId());
		preparedStatement.setString(6, order.getOrderId());
		int res=preparedStatement.executeUpdate();
		if(res>0) {
		return order;	
		}
		else {
			return null;
		}
	}

	@Override
	public Order getOrderByOrderId(String Id) throws InvalidOrderIdException {
		// TODO Auto-generated method stub
	
		String statement="select * from orders where orderid = ? ";
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
				return (new Order(res.getString("firstname"), res.getString("lastname"), res.getString("contact"), res.getString("address"), res.getString("userid"), res.getString("orderid")));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidUserIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		

		
		
		
	//	return orders.stream().filter(e->e.getOrderId().equals(Id)).findFirst().orElseThrow(()->new InvalidOrderIdException("Invalid order id."));

	}

	@Override
	public Optional<ArrayList<Order>> getOrders() {
		// TODO Auto-generated method stub
		
		
		String statement="select * from orders";
		Connection connection=null;
		ArrayList<Order>list=new ArrayList<Order>();
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
				list.add(new Order(res.getString("firstname"), res.getString("lastname"), res.getString("contact"), res.getString("address"), res.getString("userid"), res.getString("orderid")));
				 
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
	public Optional<ArrayList<Order>> getOrdersByUserId(String userId) {
		// TODO Auto-generated method stub
		
		
		
		
		String statement="select * from orders where userid = ? ";
		Connection connection=null;
		ArrayList<Order>list=new ArrayList<Order>();

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
				list.add(new Order(res.getString("firstname"), res.getString("lastname"), res.getString("contact"), res.getString("address"), res.getString("userid"), res.getString("orderid")));
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
		
		
	//	return Optional.ofNullable((ArrayList<Order>)( orders.stream().filter(e->e.getUserId().equals(userId))));
	}

	@Override
	public String removeOrderByOrderId(String id) {
		// TODO Auto-generated method stub
	//	orders = ((ArrayList<Order>)( orders.stream().filter(e->e.getOrderId()!=id)));

		
		
		String statement="delete from orders where orderid = ? ";
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
	public Order updateOrderByOrderId(String id, Order newOrder) {
		// TODO Auto-generated method stub
//		try {
//		orders=new ArrayList<Order>(orders.stream().filter(l-> !l.getOrderId().equals(id)).collect(Collectors.toList()));
//		//Arrays.asList(orders.stream().filter(l-> !l.getOrderId().equals(id) ).toArray());
//		orders.add(newOrder);
//		return newOrder;
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getLocalizedMessage());
//		}
//		/*
//		for(int i=0; i<orders.size(); i++ ){
//			Order order= orders.get(i);
//			if(order!=null && order.getOrderId().equals(id)) {
//				
//				orders.set(i, newOrder);
//				return newOrder;
//			}
//		}*/
		
		
		
		String statement="update orders set firstname = ?, lastname = ?, contact = ?, address = ?, userid = ? where orderid = ? ";
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
			
			preparedStatement.setString(1, newOrder.getFirstName());
			preparedStatement.setString(2, newOrder.getLastName());
			preparedStatement.setString(3, newOrder.getContact());
			preparedStatement.setString(4,  newOrder.getAddress());
			preparedStatement.setString(5,  newOrder.getUserId());
			preparedStatement.setString(6, id);
			
			int res=preparedStatement.executeUpdate();
			if(res>0) {
			return newOrder;
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
