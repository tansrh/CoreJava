package com.wu.ecommerce;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.InvalidIDException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.repo.ProductRepositoryImpl;
import com.wu.ecommerce.service.ProductService;
import com.wu.ecommerce.service.ProductServiceImpl;

public class Day3 {

	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	ProductService productService = ProductServiceImpl.getInstance();
	int choice=0;
	while(true) {
		
		
		
		
		
		System.out.println("");
		System.out.println("Enter 1: Create New Product");
		System.out.println("Enter 2: Get all Products");
		System.out.println("Enter 3: Get Products by Category");
		System.out.println("Enter 4: Get Product by Id");
		System.out.println("Enter 5: Remove Product by Id");
		System.out.println("Enter 6: Update Product by Id");
		System.out.println("");
		
		System.out.println("Enter your choice");
		choice=sc.nextInt();
		String id, name, category;
		float price;
		switch(choice) {
		
		
		case 1: 
			
			
			System.out.println("Enter product id");
			id=sc.next();
			System.out.println("Enter product name");
			name=sc.next();
			System.out.println("Enter product category");
			category=sc.next();
			System.out.println("Enter product price");
			price=sc.nextFloat();
			
			
			try {
				productService.addProduct(new Product(id, name, category, price));
			} catch (InvalidIDException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidPriceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2:
			Set<Product> listAll=productService.getProducts().get();
			for(Product i :listAll) {
				System.out.println(i);
			}
			break;
		case 3:
			
			System.out.println("Enter product category");
			category=sc.next();
			ArrayList<Product> listCategorical=productService.getProductsByCategory(category).get();
			for(Product i :listCategorical) {
				System.out.println(i);
			}
			break;
		case 4:
			
			System.out.println("Enter product id");
			id=sc.next();
			Product product=null;
			try {
				product = productService.getProductByProductId(id);
			} catch (InvalidIDException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(product);
			
			break;
		case 5:
			
			System.out.println("Enter product id");
			id=sc.next();
			try {
				productService.removeProductByProductId(id);
			} catch (InvalidIDException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case 6:
			System.out.println("Enter product id");
			id=sc.next();
			System.out.println("Enter product name");
			name=sc.next();
			System.out.println("Enter product category");
			category=sc.next();
			System.out.println("Enter product price");
			price=sc.nextFloat();
			
			
			try {
				productService.updateProductByProductId(id, new Product(id, name, category, price));
			} catch (InvalidIDException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidPriceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		case 7:
			break;
			
		default:
			System.out.println("Invalid input");
			break;
		}
	}
	
	
	}

}
