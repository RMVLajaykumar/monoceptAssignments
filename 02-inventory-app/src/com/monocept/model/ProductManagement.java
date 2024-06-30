package com.monocept.model;

import java.util.Random;
import java.util.Scanner;

import com.monocept.exception.DuplicateProduct;
import com.monocept.exception.InvalidProductID;

public class ProductManagement {
	 private static Scanner scanner = new Scanner(System.in);
	 static Random random=new Random();

	Inventory inventory=new Inventory();
	
	public void addProduct() {
		System.out.println("Enter the details of Product:");

        System.out.print("Enter the name of product: ");
        String productName = scanner.next();
        System.out.print("Enter the description :");
        String description = scanner.next();

        System.out.print("Enter the price of product: ");
        double price = scanner.nextDouble();

        System.out.print("Enter the initial stock quantity: ");
        int initialStock = scanner.nextInt();

        String productId = generateProductId();

        Product product = new Product(productId, productName, description, initialStock, price);
        
        try {
        	inventory.addProduct(product);
        	System.out.println("product added");
        }
        catch(DuplicateProduct e) {
        	System.out.println(e.getMessage());
        }
        
	}
	
	private String generateProductId() {
		
		  return "PROD-" + (random.nextInt(1000));
		  

	}

	public void updateProduct() {
		System.out.println("emter the id of the product");
		String productId=scanner.next();
		Product product = inventory.findProduct(productId);
		if(product==null) {
			throw new InvalidProductID();	
		}
		System.out.println("Enter \n1.Do you want to change name. \n2.do you want to change price");
		int choice=scanner.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter new name");
			product.setName(scanner.next());
			break;
		case 2:
			System.out.println("Enter new Price");
			product.setPrice(scanner.nextDouble());
			break;
		}
		System.out.println(product);
		
	}
	
	public void deleteProduct() {
		try {
		System.out.println("enter productID");
		inventory.deleteProduct(scanner.next());
		System.out.println("product deleted");
		}
		catch(InvalidProductID e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void viewProduct() {
		System.out.println("Enter Id");
		System.out.println(inventory.findProduct(scanner.next()));
		
	}
    public void viewAllProduct() {
    	inventory.viewAllProduct();
    }
}
