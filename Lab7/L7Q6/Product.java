package com.fyiernzy.Lab7;

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
