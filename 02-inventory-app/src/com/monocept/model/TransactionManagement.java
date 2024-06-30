package com.monocept.model;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.monocept.exception.InsufficientStock;

public class TransactionManagement {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    private Inventory inventory;
    private ExecutorService executorService;

    public TransactionManagement(Inventory inventory) {
        this.inventory = inventory;
        this.executorService = Executors.newFixedThreadPool(2);
    }

    public void addStock() {
        System.out.println("Enter Product ID:");
        String productId = scanner.next();
        Product product = inventory.findProduct(productId);
        String transactionId = getTransactionId();
        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();
        executorService.submit(() -> {
            synchronized (product) {
                product.setQuantity(product.getQuantity() + quantity);
                Transaction transaction = new Transaction(transactionId, productId, "Added stock", quantity, LocalDateTime.now());
                inventory.addTransaction(transaction);
            }
        });
        System.out.println("Stock updated successfully.");
    }

    private String getTransactionId() {
        return "TransactionID-" + (int) (Math.random() * 1000);
    }

    public void removeStock() {
        System.out.println("Enter Product ID:");
        String productId = scanner.next();
        Product product = inventory.findProduct(productId);
        String transactionId = getTransactionId();
        System.out.println("Enter quantity:");
        int quantity = scanner.nextInt();
        if (product.getQuantity() < quantity) {
            try {
                throw new InsufficientStock();
            } catch (InsufficientStock e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        executorService.submit(() -> {
            synchronized (product) {
                product.setQuantity(product.getQuantity() - quantity);
                Transaction transaction = new Transaction(transactionId, productId, "Removed Stock", quantity, LocalDateTime.now());
                inventory.addTransaction(transaction);
            }
        });
        System.out.println("Stock updated successfully.");
    }

    public void viewTransactionHistory() {
        inventory.viewTransactionHistory();
    }
}
