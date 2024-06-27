package com.monocept.violation.model;

public class Book {
	
	private String title;
	private String author;
	private boolean isBorrowed;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book() {
		super();
	}
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
		this.isBorrowed = false;
	}
	public boolean isBorrowed() {
		return isBorrowed;
	}
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	
	public void borrowBook(User user) {
		this.isBorrowed=true;
		System.out.println(user.getName()+" has borrowed the book");
	
		
	}
	
	public void returnBook(User user) {
		this.isBorrowed=false;
		System.out.println(user.getName()+" has returned the book");
		
	}
	public void catalogBook() {
		System.out.println("book title: "+this.title);
		System.out.println("Author: "+this.author);
		
	}

}
