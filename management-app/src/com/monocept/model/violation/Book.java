package com.monocept.model.violation;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private boolean isBorrowed;
    private User borrowedBy;
    List<Book> books = new ArrayList<>();

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public Book() {
    }

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

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public List<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", isBorrowed=" + isBorrowed + "]";
    }

    public void borrowBook(User user) {
        if (!isBorrowed) {
            this.isBorrowed = true;
            this.borrowedBy = user;
            System.out.println(user.getName() + " borrowed " + this.title);
        } else {
            System.out.println("The book " + this.title + " is already borrowed by " + this.borrowedBy.getName());
        }
    }

    public void returnBook(User user) {
        if (isBorrowed && this.borrowedBy.equals(user)) {
            this.isBorrowed = false;
            this.borrowedBy = null;
            System.out.println(user.getName() + " returned " + this.title);
        } else {
            System.out.println("The book " + this.title + " was not borrowed by " + user.getName());
        }
    }

    public void catalogBook(Book book) {
        books.add(book);
        System.out.println(book);
    }
}
