package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.Order;
import com.wu.ecommerce.exception.InvalidOrderIdException;

public interface OrderService {

	
	public Order addOrder(Order order) throws SQLException;
	public Order getOrderByOrderId(String Id) throws InvalidOrderIdException;
	public Optional<ArrayList<Order>> getOrders();
	public Optional<ArrayList<Order>> getOrdersByUserId(String userId);
	public String removeOrderByOrderId(String id);
	public Order updateOrderByOrderId(String id, Order order);
	default void display() {
		System.out.println("hello");
	}
	
}
