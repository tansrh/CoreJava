package com.wu.ecommerce.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.wu.ecommerce.dto.Order;
import com.wu.ecommerce.exception.InvalidOrderIdException;
import com.wu.ecommerce.exception.InvalidUserIdException;
import com.wu.ecommerce.service.OrderService;
import com.wu.ecommerce.service.OrderServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrderService orderService=OrderServiceImpl.getInstance();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/registerPage.jsp");
	dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		Order order=null;
		String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String address=request.getParameter("address");
		String contact=request.getParameter("contact");
		String userId=request.getParameter("userId");
		String orderId=request.getParameter("orderId");
		if(firstName.isEmpty() || lastName.isEmpty() || address.isEmpty() || contact.isEmpty() || userId.isEmpty() || orderId.isEmpty()) {
			
		}
		else {
			
			
			
			try {
				order=orderService.addOrder(new Order(firstName, lastName, contact, address, userId, orderId));
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidUserIdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidOrderIdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		if(order!=null) {
			ArrayList<Order> orderList = orderService.getOrders().get();
			
			
			ServletContext servletContext=request.getServletContext();
			servletContext.setAttribute("orderDetails", orderList);
			
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("order", order);
			RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/dashboard.jsp");
			dispatcher.forward(request, response);
		}
		System.out.println(order);
	}

}
