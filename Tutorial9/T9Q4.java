package com.fyiernzy.Tutorial9;

public class T9Q4 {

}

class PurchaseSystem {
	String productCode;
	double unitPrice;
	int quantity;
	double totalPrice;
	
	PurchaseSystem(String code, double price, int quantity){
		this.productCode = code;
		this.unitPrice = price;
		this.quantity = quantity;
	}
	
	public double calcTotalPrice() {
		return this.unitPrice * this.quantity;	
	}
	
	public void showDetails() {
		System.out.printf("Produce Code: %s\nUnit Price: %.2f\nQuantity: %d\nTotal Price: %.2f", 
				this.productCode, this.unitPrice, this.quantity, this.calcTotalPrice());
	}
}

class SugarPurchase extends PurchaseSystem {
	double sugarWeight;
	
	SugarPurchase(String code, double price, int quantity, double weight){
		super(code, price, quantity);
		this.sugarWeight = weight;
	}
	
	@Override
	public double calcTotalPrice() {
		return this.unitPrice * this.quantity * this.sugarWeight;	
	}
}