package com.monocept.solution.test;

import com.monocept.solution.model.*;

public class LibraryManagementTest {

    public static void main(String[] args) {
        Book book = new Book("Naruto", "Kishimoto");
        CatalogBook catalog = new CatalogBook();
        catalog.catalogBook(book);

        User user = new User(1, "Kumar");
        RegisterUser registerUser = new RegisterUser();
        registerUser.registerUser(user);

        Borrowedbook borrowedBook = new Borrowedbook();
        Returnedbook rb=new Returnedbook();
        BorrowedUser borrowedUser = new BorrowedUser(borrowedBook,rb);

        borrowedUser.borrowBook(book, user);
        borrowedUser.borrowBook(book, user);
        borrowedUser.returnBook(book, user);
        borrowedUser.borrowBook(book, user);
    }
}
