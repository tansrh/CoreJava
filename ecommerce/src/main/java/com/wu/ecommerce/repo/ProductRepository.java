package com.wu.ecommerce.repo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.InvalidIDException;

public interface ProductRepository {
 
	public Product addProduct(Product product) throws SQLException;
	public Product getProductByProductId(String Id) throws InvalidIDException;
//	public Optional<Product[]> getProducts();
//	public Optional<Product[]> getProductsByCategory(String category);
	public Optional<Set<Product>> getProducts();
	public Optional<ArrayList<Product>> getProductsByCategory(String category);
	public String removeProductByProductId(String id) throws InvalidIDException;
	public Product updateProductByProductId(String id, Product product) throws InvalidIDException;
	default void display() {
		System.out.println("hello");
	}
}
