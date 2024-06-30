package com.monocept.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction implements Serializable{
	private String transactionid;
	public String getTransactionid() {
		return transactionid;
	}
	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	private String productid;
	private String type;
	private int quantity;
	private LocalDateTime date;
	public Transaction(String transactionid, String productid, String type, int quantity, LocalDateTime localDate) {
		super();
		this.transactionid = transactionid;
		this.productid = productid;
		this.type = type;
		this.quantity = quantity;
		this.date = localDate;
	}
	@Override
	public String toString() {
		return "Transaction [transactionid=" + transactionid + ", productid=" + productid + ", type=" + type
				+ ", quantity=" + quantity + ", date=" + date + "]";
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	
	public Transaction() {
		super();
	}
	

}
