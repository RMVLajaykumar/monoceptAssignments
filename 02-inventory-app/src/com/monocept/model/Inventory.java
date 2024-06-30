package com.monocept.model;

import java.util.List;

import com.monocept.exception.DuplicateProduct;
import com.monocept.exception.DuplicateSupplier;
import com.monocept.exception.InvalidProductID;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Inventory  {
	
	List<Product>products= new ArrayList<Product>();
	List<Supplier>suppliers=new ArrayList<Supplier>();
	List<Transaction>transactions=new ArrayList<Transaction>();
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Supplier> getSuppliers() {
		return suppliers;
	}
	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public void addProduct(Product product) {
		for(Product prod:products) {
			if(prod.getProductid().equals(product.getProductid()))
				throw new DuplicateProduct();
		}
		products.add(product);
		
	}
	public Product findProduct(String Id) {
		for(Product prod:products) {
			if(prod.getProductid().equals(Id))
				return prod;
		}
		return null;
		
	}
	public void deleteProduct(String ID) {
		Product product=findProduct(ID);
		if(product==null) {
			throw new InvalidProductID();
		}
		products.remove(product);
		
		
	}
	public void viewAllProduct() {
		for(Product prod:products) {
			System.out.println(prod);
		}
		
	}
	public void addSupplier(Supplier supplier) {
		for(Supplier supp:suppliers) {
			if(supp.getId().equals(supplier.getId()))
				throw new DuplicateSupplier();
			
		}
		suppliers.add(supplier);
	}
	public Supplier findSupplier(String Id) {
		for(Supplier supp:suppliers) {
			if(supp.getId().equals(Id))
				return supp;
		}
		return null;
	}
	
	public boolean deleteSupplier(String ID) {
		Supplier supplier=findSupplier(ID);
		suppliers.remove(supplier);
		return true;
	}
	public void viewAllSupplier() {
		for(Supplier supp:suppliers) {
			System.out.println(supp);
		}
	}
	
	public void viewTransactionHistory() {
		for(Transaction trans:transactions) {
			System.out.println(trans);
		}
	}
	
	public void addStock(Transaction transaction) {
		transactions.add(transaction);
		
	}
	public void removeStock(Transaction transaction) {
		transactions.add(transaction);
		
	}
	public void generateReports() {
		System.out.println("total products"+products.size());
		for(Product product:products) {
			System.out.println(product.getName()+": and its total value"+(product.getQuantity()*product.getPrice()));
		}
		
	}
	public void saveData() throws IOException {
	    saveListToFile(products, "D:\\homeAssignments\\02-inventory-app\\src\\com\\monocept\\model\\Product.txt");
	    saveListToFile(suppliers, "D:\\homeAssignments\\02-inventory-app\\src\\com\\monocept\\model\\Supplier.txt");
	    saveListToFile(transactions, "D:\\homeAssignments\\02-inventory-app\\src\\com\\monocept\\model\\Transaction.txt");
	}

	private <T> void saveListToFile(List<T> list, String fileName) throws IOException {
	    try (FileOutputStream fos = new FileOutputStream(fileName);
	         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
	    	
	        for (T item : list) {
	            oos.writeObject(item);
	            
	        }
	        System.out.println("saved sucussfully");
	    }
	}


	
	
	 public void loadData() throws IOException, ClassNotFoundException {
	        loadListFromFile("D:\\\\homeAssignments\\\\02-inventory-app\\\\src\\\\com\\\\monocept\\\\model\\\\Product.txt", products);
	        loadListFromFile("D:\\\\homeAssignments\\\\02-inventory-app\\\\src\\\\com\\\\monocept\\\\model\\\\Supplier.txt", suppliers);
	        loadListFromFile("D:\\\\homeAssignments\\\\02-inventory-app\\\\src\\\\com\\\\monocept\\\\model\\\\Transaction.txt", transactions);

	        System.out.println("Loaded the data from file successfully\n");
	    }

	    private <T> void loadListFromFile(String fileName, List<T> list) throws IOException, ClassNotFoundException {
	        try (FileInputStream fis = new FileInputStream(fileName);
	             ObjectInputStream ois = new ObjectInputStream(fis)) {
	            while (true) {
	                try {
	                    T item = (T) ois.readObject();
	                    if (item == null) {
	                        break;
	                    }
	                    System.out.println(item);
	                    if (!list.contains(item)) {
	                        list.add(item);
	                    }
	                } catch (EOFException e) {
	                    break;
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("File not found: " + fileName);
	        }
	    }
	    
	    
	    public void addTransaction(Transaction transaction) {
	      transactions.add(transaction);
	    }



}
