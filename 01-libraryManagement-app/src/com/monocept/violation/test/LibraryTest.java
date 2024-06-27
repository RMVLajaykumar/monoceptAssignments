package com.monocept.violation.test;

import com.monocept.violation.model.Book;
import com.monocept.violation.model.User;

public class LibraryTest {

	public static void main(String[] args) {
		Book book=new Book("ONE PIECE","ODA");
		book.catalogBook();
		User user=new User(1,"Ajay");
		
		user.borrowBook(book,user);
		user.borrowBook(book,user);
		book.returnBook(user);
		user.borrowBook(book,user);
		
	}

}
