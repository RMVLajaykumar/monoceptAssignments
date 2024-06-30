package com.monocept.model;

import java.io.Serializable;

public class Product implements Serializable {
	private String productid;
	private String name;
	private String description;
	private int quantity;
	private double price;
	public String getProductid() {
		return productid;
	}
	public void setId(String productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	
	
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product(String productid, String name, String description, int quantity, double price) {
		super();
		this.productid = productid;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", description=" + description + ", quantity="
				+ quantity + ", price=" + price + "]";
	}
	public Product() {
		super();
	}
	
	

}
