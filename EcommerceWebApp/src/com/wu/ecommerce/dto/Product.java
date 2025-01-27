package com.wu.ecommerce.dto;

import com.wu.ecommerce.exception.InvalidIDException;
import com.wu.ecommerce.exception.InvalidPriceException;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode

@NoArgsConstructor
public class Product
//implements Comparable<Product>
{

	private String productId;
	private String productName;
	private String categoryName;
	@lombok.ToString.Exclude
	private float price;

	/*
	 * @Override public String toString() { return this.productId + " " +
	 * this.productName + " " + this.categoryName + " " + this.price; }
	 */
//	@Override
//	public int compareTo(Product o) {
//		// TODO Auto-generated method stub
//		return (int) (this.price-o.price);
//	}
	public void setProductId(String productId) throws InvalidIDException {
		if (productId == null || productId.equals("") || productId.length() > 3) {
			throw new InvalidIDException("Invalid ID");
		}
		this.productId = productId;
	}

	public void setPrice(float price) throws InvalidPriceException {
		if (price < (0f)) {
			throw new InvalidPriceException("Invalid Price");
		}
		this.price = price;
	}

	public Product(String productId, String productName, String categoryName, float price)
			throws InvalidIDException, InvalidPriceException {
		super();
		this.setProductId(productId);
		this.productName = productName;
		this.categoryName = categoryName;
		this.setPrice(price);
	}
}
