package com.monocept.solution.model;

public class BorrowedUser {
    
    private Ibook borrowBook;
    private Ireturn returnBook;

    public BorrowedUser(Ibook borrowBook, Ireturn returnBook) {
        this.borrowBook = borrowBook;
        this.returnBook = returnBook;
    }

    public void borrowBook(Book book, User user) {
        if (book.isBorrowed()) {
            System.out.println("Currently, the book is not available");
            return;
        }
        borrowBook.borrowBook(user, book);
    }

    public void returnBook(Book book, User user) {
        returnBook.returnBook(user, book);
    }
}
