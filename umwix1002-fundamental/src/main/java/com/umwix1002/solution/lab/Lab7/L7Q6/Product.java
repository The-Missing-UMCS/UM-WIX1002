package com.umwix1002.solution.lab.Lab7.L7Q6;

public class Product {
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
