package com.fyiernzy.Lab7;

import java.io.*;
import java.util.*;

public class L7Q6 {
	String productFile = "./io_files/product.txt";
	String orderFile = "./io_files/order.txt";
	
	public static void main(String[] args) {
		new L7Q6().run();
	}
	
	public void run() {
		writeProductFile();
		writeOrderFile();
		showList();
	}
	
	public void writeProductFile() {
		try {
			PrintWriter writer = new PrintWriter(productFile);
			writer.println("SK079,Dettol Natural,4.99");
			writer.println("SK013,100 Plus,6.49");
			writer.println("SK088,Jasmine Pearl,37.99");
			writer.println("SK042,Ayamas Nuget Crispy,9.99");
			writer.println("SK066,Ali Cafe,8.99");
			
			writer.close();
		} catch (Exception ex) {
			
		}
	}
	
	public void writeOrderFile() {
		try {
			PrintWriter writer = new PrintWriter(orderFile);
			writer.println("SK079,Dettol Natural,20");
			writer.println("SK013,100 Plus,74");
			writer.println("SK088,Jasmine Pearl,27");
			writer.println("SK042,Ayamas Nuget Crispy,60");
			writer.println("SK066,Ali Cafe,79");
			
			writer.close();
		} catch (Exception ex) {
			
		}
	}
	
	public HashMap<String, Product> getProductList() {
		HashMap<String, Product> productList = new HashMap<String, Product>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(productFile));
			String line = "";
			
			while((line = reader.readLine()) != null) {
				String[] info = line.split(",");
				productList.put(info[0], new Product(info[0], info[1], Double.parseDouble(info[2])));
			}
			
			reader.close();
			
		} catch (Exception ex) {}
		
		return productList;
	}
	
	public void showList() {
		HashMap<String, Product> productList = getProductList();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(orderFile));
			String line = "";
			
			System.out.printf(" %-15s%-25s%-10s%15s%15s\n",
					"ProductID","ProductName","Quantity","PricePerUnit","Total");
			
			while((line = reader.readLine()) != null) {
				String[] info = line.split(",");
				int unit = Integer.parseInt(info[2]);
				Product product = productList.get(info[0]);
				
				System.out.printf(" %-15s%-25s%-10d%15.2f%15.2f\n", 
						product.productID, product.productName, unit, 
						product.productPrice, product.getTotalPrice(unit));
			}
			
			reader.close();
		} catch (Exception ex) {}
	}
}

class Product {
	String productID;
	String productName;
	double productPrice;
	
	Product(String id, String name, double price){
		this.productID = id;
		this.productName = name;
		this.productPrice = price;
	}
	
	public double getTotalPrice(int quantity) {
		return this.productPrice * quantity;
	}
}