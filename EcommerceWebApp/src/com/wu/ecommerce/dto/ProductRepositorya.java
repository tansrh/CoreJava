package com.wu.ecommerce.dto;


import java.util.Optional;

import com.wu.ecommerce.dto.Product;

public interface ProductRepositorya {
 
	public Product addProduct(Product product);
	public Optional<Product> getProductByProductId(String Id);
	public Optional<Product[]> getProducts();
	public Optional<Product[]> getProductsByCategory(String category);
	public String removeProductByProductId(String id);
	public Product updateProductByProductId(String id, Product product);
	default void display() {
		System.out.println("hello");
	}
}

