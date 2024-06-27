package com.monocept.model.violation;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String userId;
    List<User> users = new ArrayList<>();

    public User(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<User> getUsers() {
        return users;
    }

    public void registerUser(User user) {
        users.add(user);
        System.out.println(user);
    }

    @Override
    public String toString() {
        return "User [name=" + name + ", userId=" + userId + "]";
    }

    public void borrowBook(Book book, User user) {
        book.borrowBook(this);
    }

    public void returnBook(Book book, User user) {
        book.returnBook(this);
    }
}
