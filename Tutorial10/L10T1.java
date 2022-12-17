package com.fyiernzy.Tutorial10;

public class L10T1 {
	public static void main(String[] args) {
		BulkDiscount bd = new BulkDiscount(5, 0.4);
		OtherDiscount od = new OtherDiscount();
		CombineDiscount cd = new CombineDiscount(bd, od);
		System.out.printf("%.2f", cd.computeDiscount(10, 4.5));
	}
}

abstract class DiscountPolicy {
	abstract double computeDiscount(int count, double itemCost);
}

class BulkDiscount extends DiscountPolicy {
	private int minimum;
	private double discountRate;
	
	BulkDiscount(int minimum, double discountRate){
		this.minimum = minimum;
		this.discountRate = discountRate;
	}
	
	@Override
	public double computeDiscount(int count, double itemCost) {	
		return (count * itemCost * ((count > this.minimum) ? (1 - discountRate) : 1));
	}
}

class OtherDiscount extends DiscountPolicy {
	@Override
	public double computeDiscount(int count, double itemCost) {	
		double discount = 0.0;
		if (count > 8) discount = 0.3;
		else if (count >= 6) discount = 0.2;
		else if (count >= 3) discount = 0.1;
		
		return (count * itemCost * (1 - discount));
	}
}

class CombineDiscount extends DiscountPolicy {
	DiscountPolicy dp1;
	DiscountPolicy dp2;
	
	CombineDiscount(DiscountPolicy dp1, DiscountPolicy dp2) {
		this.dp1 = dp1;
		this.dp2 = dp2;
	}
	
	@Override
	public double computeDiscount(int count, double itemCost) {
		return (Math.max(dp1.computeDiscount(count, itemCost), dp2.computeDiscount(count, itemCost)));
	}
}
