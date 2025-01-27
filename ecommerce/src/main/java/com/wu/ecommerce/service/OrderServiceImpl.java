package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.Order;
import com.wu.ecommerce.exception.InvalidOrderIdException;
import com.wu.ecommerce.repo.OrderRepository;
import com.wu.ecommerce.repo.OrderRepositoryImpl;
import com.wu.ecommerce.repo.ProductRepository;
import com.wu.ecommerce.repo.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService{
	
	private OrderRepository orderRepository=OrderRepositoryImpl.getInstance();
	private static OrderService orderService;
	public static OrderService getInstance() {
		if(orderService==null) {
			orderService=new OrderServiceImpl();
			
		}
		return orderService;
	}
	@Override
	public Order addOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		return orderRepository.addOrder(order);
	}

	@Override
	public Order getOrderByOrderId(String Id) throws InvalidOrderIdException {
		// TODO Auto-generated method stub
		return orderRepository.getOrderByOrderId(Id);
	}

	@Override
	public Optional<ArrayList<Order>> getOrders() {
		// TODO Auto-generated method stub
		return orderRepository.getOrders();
	}

	@Override
	public Optional<ArrayList<Order>> getOrdersByUserId(String userId) {
		// TODO Auto-generated method stub
		return orderRepository.getOrdersByUserId(userId);
	}

	@Override
	public String removeOrderByOrderId(String id) {
		// TODO Auto-generated method stub
		return orderRepository.removeOrderByOrderId(id);
	}

	@Override
	public Order updateOrderByOrderId(String id, Order order) {
		// TODO Auto-generated method stub
		return orderRepository.updateOrderByOrderId(id, order);
	}

}
