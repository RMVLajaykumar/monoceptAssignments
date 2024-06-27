package com.monocept.solution.model;

public class Returnedbook implements Ireturn {

    @Override
    public void returnBook(User user, Book book) {
        book.setBorrowed(false);
        System.out.println(user.getName() + " has returned the book");
    }
}
