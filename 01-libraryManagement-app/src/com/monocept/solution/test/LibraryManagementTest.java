package com.monocept.solution.test;

import com.monocept.solution.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();
        System.out.println("welcome to Library!");
        System.out.println("enter details:");
        User user = getUserDetails(scanner);

        RegisterUser registerUser = new RegisterUser();
        registerUser.registerUser(user);

        Borrowedbook borrowedBook = new Borrowedbook();
        Returnedbook returnedBook = new Returnedbook();
        BorrowedUser borrowedUser = new BorrowedUser(borrowedBook, returnedBook);

        boolean exit = false;
        
        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    catalogBook(books);
                    break;
                case 2:
                    addBook(scanner, books);
                    break;
                case 3:
                    borrowBook(scanner, borrowedUser, books, user);
                    break;
                case 4:
                    returnBook(scanner, borrowedUser, books, user);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thankyou!!!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
      
    }

    private static void displayMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Catalog Books");
        System.out.println("2. Add a Book");
        System.out.println("3. Borrow a Book");
        System.out.println("4. Return a Book");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static User getUserDetails(Scanner scanner) {
        System.out.print("Enter user name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter user ID: ");
        String userID = scanner.nextLine();
        return new User(userName, userID);
    }

    private static void catalogBook(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books in catalog.");
        } if(!(books.isEmpty())) {
            System.out.println("\nCataloged Books:");
            for (int i = 0; i < books.size(); i++) {
                System.out.println((i + 1) + ". " + books.get(i).getTitle() + " by " + books.get(i).getAuthor());
            }
        }
    }

    private static void addBook(Scanner scanner, List<Book> books) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        Book book = new Book(title, author);
        books.add(book);
        System.out.println("Book added to catalog.");
    }

    private static void borrowBook(Scanner scanner, BorrowedUser borrowedUser, List<Book> books, User user) {
        catalogBook(books);
        System.out.print("Enter book number to borrow: ");
        int bookIndex = scanner.nextInt();
        scanner.nextLine(); 
        if (bookIndex > 0 && bookIndex <= books.size()) {
            Book selectedBook = books.get(bookIndex - 1);
            borrowedUser.borrowBook(selectedBook, user);
        }  if (!(bookIndex > 0 && bookIndex <= books.size())) {
            System.out.println("Invalid book number.");
        }
    }

    private static void returnBook(Scanner scanner, BorrowedUser borrowedUser, List<Book> books, User user) {
        catalogBook(books);
        System.out.print("Enter book number to return: ");
        int bookIndex = scanner.nextInt();
        scanner.nextLine();
        if (bookIndex > 0 && bookIndex <= books.size()) {
            Book selectedBook = books.get(bookIndex - 1);
            borrowedUser.returnBook(selectedBook, user);
        }  if (!(bookIndex > 0 && bookIndex <= books.size())) {
            System.out.println("Invalid book number.");
        }
    }
}
