package com.monocept.solution.model;



public class Borrowedbook  implements Ibook{
	
	@Override
	public void borrowBook(User user,Book book) {
		book.setBorrowed(true);
		System.out.println(user.getName()+" has borrowed the book");
	
	}
		
	}


