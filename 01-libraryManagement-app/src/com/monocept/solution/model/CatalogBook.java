package com.monocept.solution.model;

public class CatalogBook {
    public void catalogBook(Book book) {
        System.out.println("Book title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
    }
}
