<%@page import="java.util.ArrayList"%>
<%@page import="com.wu.ecommerce.dto.Order"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<h3>
<table style=" border: 1px solid white;border-collapse: collapse;">
<th>Order id</th><th>Name</th>
<%

Order order= (Order)session.getAttribute("order");%>
<h4><i style="color:red">Welcome <%= order.getFirstName() %></i></h4><%
ArrayList<Order>list=(ArrayList<Order>) application.getAttribute("orderDetails");

for(Order i: list){
	%>
	<tr ><td style=" border: 1px solid white;border-collapse: collapse;background-color: #96D4D4;">
	<% 
	out.print(i.getOrderId());
	%></td><td style="border: 1px solid white;border-collapse: collapse; background-color: #96D4D4;"><% 
	out.print(" "+i.getFirstName()+" "+i.getLastName());
	%></td> </tr><%
}

//list.forEach(e->{try{System.out.println(e);}catch(Exception e2 ){}});



%>
</table>

<h3><a href="logout">Logout</a></h3>

</h3>
</body>
</html>