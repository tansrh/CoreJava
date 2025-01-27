package com.wu.ecommerce;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import com.wu.ecommerce.dto.Order;
import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.InvalidIDException;
import com.wu.ecommerce.exception.InvalidOrderIdException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.exception.InvalidUserIdException;
import com.wu.ecommerce.repo.OrderRepositoryImpl;
import com.wu.ecommerce.service.OrderService;
import com.wu.ecommerce.service.OrderServiceImpl;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		
		ProductService productService=ProductServiceImpl.getInstance();
		OrderService orderService=OrderServiceImpl.getInstance();

		/*
		Product products[]=new Product[10];
		System.out.println(products.length);
		for (Product product : products) {
			System.out.println(product);
		}
		*/
		/*
		try {
			System.out.println(orderService.addOrder(new Order("John", "Doe", "99", "Pune", "abcid", "bcdid")));
		} catch (InvalidUserIdException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InvalidOrderIdException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		Optional<ArrayList<Order>> orders = orderService.getOrders();
		if(orders.isPresent()){
			ArrayList<Order> list=orders.get();
			for(Order i: list) {
				System.out.println(i);
			}
		}
		try {
			
			orderService.updateOrderByOrderId("bcdid", new Order("John", "Donald", "99", "Pune", "abcbcid", "bcdid"));
			orderService.removeOrderByOrderId("bcdid");
		} catch (InvalidUserIdException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (InvalidOrderIdException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		orders=orderService.getOrders();
		orders.ifPresent(products->{
			for(Order order: products) {
				
				System.out.println(order.toString());
				System.out.println(order.hashCode());
				System.out.println(Integer.toHexString(order.hashCode()));
			}
			
		});
		
		for(int i=0; i<20; i++) {
			String category;
			if(i<=5) {
				category="Mobile";
			}
			else if(i<=10) {
				category="Laptops";
			}
			else {
				category="Computer";
			}
			try {
				
					productService.addProduct(new Product("a"+(i+1), "Apple"+i, category, (i*100)+10));

				
			}
			catch(InvalidIDException e) {
				e.printStackTrace();
			}
			catch(InvalidPriceException e){
				e.printStackTrace();
			}
		}
		Optional<ArrayList<Product>> arr=productService.getProducts();
		arr.ifPresent(products->{
			for(Product product: products) {
				
				System.out.println(product);
				System.out.println(product.hashCode());
				System.out.println(Integer.toHexString(product.hashCode()));
			}
			
		});
		
		Optional<Product> prod;
		
		try {
			prod = Optional.of(productService.getProductByProductId("a5"));
			prod.ifPresent(product->{
				
					System.out.println(product);
				
				
			});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			productService.updateProductByProductId("a5", new Product("a5", "Appleupdated", "Smartphones", (700)+10));
		} catch (InvalidIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InvalidPriceException e) {
			e.printStackTrace();
		}
		
		arr=productService.getProducts();
		arr.ifPresent(products->{
			for(Product product: products) {
				
				System.out.println(product);
				System.out.println(product.hashCode());
				System.out.println(Integer.toHexString(product.hashCode()));
			}
			
		});
		
		
		*/
		
		/*
		Optional<Product []> arr=productService.getProducts();
		arr.ifPresent(products->{
			for(Product product: products) {
				
				System.out.println(product);
				System.out.println(product.hashCode());
				System.out.println(Integer.toHexString(product.hashCode()));
			}
			
		});
	
		arr=productService.getProductsByCategory("Mobile");
		arr.ifPresent(products->{
			for(Product product: products) {
				System.out.println(product);
			}
			
		});
		Optional<Product> prod=productService.getProductByProductId("a5");
		try {
			prod.ifPresent(product->{
				
					System.out.println(product);
				
				
			});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			productService.updateProductByProductId("a5", new Product("a5", "Appleupdated", "Smartphones", (700)+10));
		} catch (InvalidIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InvalidPriceException e) {
			e.printStackTrace();
		}
		prod=productService.getProductByProductId("a5");
		prod.ifPresent(product->{
			
				System.out.println(product);
			
			
		});
		System.out.println(productService.removeProductByProductId("a5"));
		
		arr=productService.getProducts();
		arr.ifPresent(products->{
			for(Product product: products) {
				System.out.println(product);
			}
			
		});
		
		
		*/
		
		OrderService orderService=new OrderServiceImpl().getInstance();
	/*	
		try {
			orderService.addOrder(new Order("johnnnn", "dareee", "99118", "puneri", "userid1", "orderid3"));
		} catch (SQLException | InvalidUserIdException | InvalidOrderIdException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		orderService.getOrders().get().forEach(e-> System.out.println(e));
		/*
		try {
			orderService.getOrderByOrderId("orderid");
		} catch (InvalidOrderIdException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		orderService.getOrdersByUserId("userid").get().forEach(e->System.out.println(e));
		try {
			orderService.updateOrderByOrderId("orderid", new Order("johny", "depp", "9987", "los angeles", "useridjohn", "orderid3"));
		} catch (InvalidUserIdException | InvalidOrderIdException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		orderService.getOrdersByUserId("userid1");
		*/
	//	System.out.println(orderService.removeOrderByOrderId("orderid3"));
		orderService.getOrders().get().forEach(e-> System.out.println(e));

	}

}
