package com.monocept.solution.model;

public class Book {
	String title;
	private String author;
	private boolean isBorrowed;
	public Book() {
		super();
	}
	public Book(String title, String author) {
		super();
		this.title = title;
		this.author = author;
		this.isBorrowed=false;
	}
	public String getTitle() {
		return title;
	}
	public boolean isBorrowed() {
		return isBorrowed;
	}
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
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

}
