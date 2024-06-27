package com.monocept.violation.model;

public class User {
	private int id;
	private String name;
	public User() {
		super();
	}
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		registerUser();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void borrowBook(Book book,User user) {
		if(book.isBorrowed()==true) {
			System.out.println("currently book not available");
			return ;
		}
		book.borrowBook(user);
		
		
	}
	public void registerUser() {
		System.out.println("user registered with name: "+this.name);
		
	}

}
