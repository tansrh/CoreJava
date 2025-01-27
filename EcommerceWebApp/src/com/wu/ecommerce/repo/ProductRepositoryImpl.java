package com.wu.ecommerce.repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import com.wu.ecommerce.dto.Product;
import com.wu.ecommerce.exception.InvalidIDException;
import com.wu.ecommerce.exception.InvalidPriceException;
import com.wu.ecommerce.repo.ProductRepository;
import com.wu.ecommerce.utils.DBUtils;
import com.wu.ecommerce.utils.IdComparator;

public class ProductRepositoryImpl implements ProductRepository {
	private ProductRepositoryImpl() {
	// TODO Auto-generated constructor stub
		
	}
	private static  ProductRepository productRepository;
//	private Product[] products=new Product[10];
//	private TreeSet<Product> products=new TreeSet<Product>((Product o1,Product o2)-> o1.getProductName().compareTo(o2.getProductName()) );
//	private static int counter=-1;
	public static ProductRepository getInstance() {
		if(productRepository==null) {
			 productRepository=new ProductRepositoryImpl();
		}
		return productRepository;
	}
	@Override
	public Product addProduct(Product product) throws SQLException {
		// TODO Auto-generated method stub
		/*
		if((counter+1)==products.length) {
			Product[] newProducts=new Product[products.length+1+ ((products.length*2)/3)];
			for (int i = 0; i < products.length; i++) {
				newProducts[i]=products[i];
			}
			
			products=newProducts;
			
			
		}
		products[++counter]=product;
		return product;
		*/
	//	boolean result=products.add(product);

		
		String statement="insert into product (PRODUCTID, PRODUCTNAME, PRICE, CATEGORYNAME) values(?, ?, ?, ?) ";
		Connection connection=null;
		try {
			connection = DBUtils.getInstance().getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement preparedStatement=connection.prepareStatement(statement);
		preparedStatement.setString(1, product.getProductId());
		preparedStatement.setString(2, product.getProductName());
		preparedStatement.setFloat(3, product.getPrice());
		preparedStatement.setString(4, product.getCategoryName());
		int res=preparedStatement.executeUpdate();
		if(res>0) {
		return product;	
		}
		else {
			return null;
		}
	/*
		if(result) {
			return null;
		}
		return product;
	*/
	}

	@Override
	public Product getProductByProductId(String Id) throws InvalidIDException {
		// TODO Auto-generated method stub
		/*
		for(Product product: products) {
			if(product!=null && product.getProductId().equals(Id)) {
				return Optional.of(product);
			}
		}
		return Optional.empty();
		*/
		
		
		
		
		String statement="select * from product where PRODUCTID = ? ";
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
				return (new Product(res.getString("PRODUCTID"), res.getString("PRODUCTNAME"), res.getString("CATEGORYNAME"), res.getFloat("PRICE")));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidPriceException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
		
		
		//return products.stream().filter(e->(e!=null && e.getProductId().equals(Id))).findFirst().orElseThrow(()->new InvalidIDException("id not found"));
		
	}
	/*
	@Override
	public Optional<Product[]> getProducts() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(products);
	}
	*/
	@Override
	public Optional<Set<Product>> getProducts() {
		// TODO Auto-generated method stub
		
		
		String statement="select * from product";
		Connection connection=null;
		Set<Product>set=new HashSet<Product>();
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
				set.add(new Product(res.getString("PRODUCTID"), res.getString("PRODUCTNAME"), res.getString("CATEGORYNAME"), res.getFloat("PRICE")));
				 
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPriceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return Optional.ofNullable(set);
	}
	/*
	@Override
	public Optional<Product[]> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		
		List<Product> arr=new ArrayList<>();
		for(Product product: products) {
			if(product!=null && product.getCategoryName()!=null && product.getCategoryName().equals(category)) {
				arr.add(product);
				
			}
		}
		Product[] newarr=new Product[arr.size()];
		for (int i = 0; i < newarr.length; i++) {
			newarr[i]=arr.get(i);
		}
		
		int size=0;
		for(Product product: products) {
			if(product!=null && product.getCategoryName()!=null && product.getCategoryName().equals(category)) {
				size++;
				
			}
		}
		Product[] newarr=new Product[size];
		int index=0;
		for(Product product: products) {
			if(product!=null && product.getCategoryName()!=null && product.getCategoryName().equals(category)) {
				newarr[index++]=product;
				
			}
		}
		
		
		return Optional.ofNullable(newarr);
	}
	*/
	
	@Override
	public Optional<ArrayList<Product>> getProductsByCategory(String category) {
		
		
		ArrayList<Product> results=new ArrayList<>();
		
		
		
		String statement="select * from product where CATEGORYNAME = ? ";
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
			preparedStatement.setString(1, category);
			
			ResultSet res=preparedStatement.executeQuery();
			if(res.next()) {
			//	System.out.println(res.getString(1) +" "+ res.getString(2) +" "+ res.getString(3) +" "+ res.getString(4)); 
				results.add(new Product(res.getString("PRODUCTID"), res.getString("PRODUCTNAME"), res.getString("CATEGORYNAME"), res.getFloat("PRICE")));

				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvalidIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPriceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Optional.ofNullable(results);
		
		
		/*
		ArrayList<Product> results=new ArrayList<>();
		
		for(Product product: products) {
			if(product!=null && product.getCategoryName().equals(category)) {
				results.add(product);
			}
		}
		
		return Optional.ofNullable(results);
		*/
//		return Optional.ofNullable(new ArrayList<Product> ( products.stream().filter(e->(e!=null && e.getCategoryName().equals(category))).collect(Collectors.toList())));
	
	}
	@Override
	public String removeProductByProductId(String id) throws InvalidIDException {
		// TODO Auto-generated method stub
		
		/*
		boolean found=false;
		for(int i=0; i<products.length; i++ ){
			Product product= products[i];
			if(!found) {
			if(product!=null && product.getProductId().equals(id)) {
				found=true;
				i--;
				
				
			}
			}
			else {
				if(i+1<products.length) {
					products[i]=products[i+1];
				}
				else {
					products[i]=null;
				}
			}
			
		}
		if(found) {
			counter--;
			return "Deleted product with id : " + id;
		}
		else {
			return "No such product found";
		}
		*/
		
		String statement="delete from product where PRODUCTID = ? ";
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
			if(res>0) {
			System.out.println(res); 
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	//	products.remove(this.getProductByProductId(id));
	//	products = (new ArrayList<Product>( products.stream().filter(e->e.getProductId()!=id).collect(Collectors.toList())));

		return "Operation executed";
		
	}

	@Override
	public Product updateProductByProductId(String id, Product newProduct) throws InvalidIDException {
		// TODO Auto-generated method stub
		
		/*
		for(int i=0; i<products.length; i++ ){
			Product product= products[i];
			if(product!=null && product.getProductId().equals(id)) {
				products[i]= (newProduct);
				return products[i];
			}
		}
		return null;
		*/
		
		/*
		String statement="delete from product where PRODUCTID = ? ";
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
			if(res>0) {
			this.addProduct(newProduct);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		products.remove(this.getProductByProductId(id));
		products.add(newProduct);
		
		
		*/
		
		
		/*
		for(int i=0; i<products.size(); i++ ){
			Product product= products.get(i);
			if(product!=null && product.getProductId().equals(id)) {
				products.set(i, newProduct);
				return newProduct;
			}
		}
		*/
		String statement="update product set PRODUCTNAME = ?, CATEGORYNAME = ?, PRICE = ? where PRODUCTID = ? ";
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
			
			preparedStatement.setString(1, newProduct.getProductName());
			preparedStatement.setString(2, newProduct.getCategoryName());
			preparedStatement.setFloat(3, newProduct.getPrice());
			preparedStatement.setString(4, id);
			
			int res=preparedStatement.executeUpdate();
			if(res>0) {
			return newProduct;
			}
			else {
				return null;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	//	products.remove(this.getProductByProductId(id));
	//	products.add(newProduct);
		

		return null;
		
		
		
	}

}


