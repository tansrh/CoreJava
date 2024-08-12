package com.wu.ecommerce.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.InvalidIDException;
import com.wu.ecommerce.repo.ProductRepository;
import com.wu.ecommerce.repo.ProductRepositoryImpl;

public class ProductServiceImpl implements ProductService {
	
	private ProductRepository productRepository=ProductRepositoryImpl.getInstance();
	private static ProductService productService;
	public static ProductService getInstance() {
		if(productService==null) {
			productService=new ProductServiceImpl();
			
		}
		return productService;
	}
	@Override
	public Product addProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return productRepository.addProduct(product);
	}

	@Override
	public Product getProductByProductId(String Id) throws InvalidIDException {
		// TODO Auto-generated method stub
		return productRepository.getProductByProductId(Id);
	}

	@Override
	public Optional<Set<Product>> getProducts() {
		// TODO Auto-generated method stub
		return productRepository.getProducts();
	}

	@Override
	public Optional<ArrayList<Product>> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return productRepository.getProductsByCategory(category);
	}

	@Override
	public String removeProductByProductId(String id) throws InvalidIDException {
		
		return productRepository.removeProductByProductId(id);
	}

	@Override
	public Product updateProductByProductId(String id, Product product) throws InvalidIDException {
		// TODO Auto-generated method stub
		return productRepository.updateProductByProductId(id, product);
	}

}
