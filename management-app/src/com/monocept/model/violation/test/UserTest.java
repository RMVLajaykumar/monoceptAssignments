package com.monocept.model.violation.test;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.monocept.model.violation.Book;
import com.monocept.model.violation.User;

public class UserTest {
    public static void main(String[] args) {
        User user = new User();
        Book book = new Book();
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        System.out.println("Welcome to the library");

        while (!exit) {
            System.out.println("Choose option: \n1. Register a User \n2. Add a book \n3. Borrow a book \n4. Return a book \n5. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("You chose to register a user");
                    registerUser(scanner, user);
                    break;
                case 2:
                    System.out.println("You chose to add a book");
                    addBook(scanner, book);
                    break;
                case 3:
                    System.out.println("You chose to borrow a book");
                    borrowBook(book, user, scanner);
                    break;
                case 4:
                    System.out.println("You chose to return a book");
                    returnBook(book, user, scanner);
                    break;
                case 5:
                    exit = true;
                    System.out.println("thankyou!!!");
                    break;
                
            }
        }

        scanner.close();
    }

    private static void returnBook(Book book, User user, Scanner scanner) {
        List<User> users = user.getUsers();
        List<Book> books = book.getBooks();
        System.out.print("Enter User ID: ");
        String userID = scanner.next();
        System.out.print("Enter Book title: ");
        String bookTitle = scanner.next();
        for (User u : users) {
            if (u.getUserId().equals(userID)) {
                user = u;
                break;
            }
        }
        for (Book b : books) {
            if (b.getTitle().equals(bookTitle)) {
                book = b;
                break;
            }
        }
        book.returnBook(user);
        
        
    }

    private static void borrowBook(Book book, User user, Scanner scanner) {
        List<User> users = user.getUsers();
        List<Book> books = book.getBooks();
        if (!books.isEmpty()) {
            System.out.println("Available Books:");
            for (Book b : books) {
                if (!b.isBorrowed()) {
                    System.out.println(b.getTitle() + " by " + b.getAuthor());
                }
            }
        } else {
            System.out.println("Sorry, no books are available.");
            return;
        }

        System.out.print("Enter User ID: ");
        String userID = scanner.next();
        System.out.print("Enter Book title: ");
        String bookTitle = scanner.next();
        for (User u : users) {
            if (u.getUserId().equals(userID)) {
                user = u;
                break;
            }
        }
        for (Book b : books) {
            if (b.getTitle().equals(bookTitle)) {
                book = b;
                break;
            }
        }
        user.borrowBook(book, user);
    }

    private static void addBook(Scanner scanner, Book book) {
        System.out.print("Enter the title: ");
        String title = scanner.next();
        System.out.print("Enter the author: ");
        String author = scanner.next();
        book.catalogBook(new Book(title, author));
    }

    private static void registerUser(Scanner scanner, User user) {
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter your ID: ");
        String userID = scanner.next();
        user.registerUser(new User(name, userID));
    }
}
