package com.umwix1002.solution.tutorial.Tutorial10.L10T1;

public class Main {
	public static void main(String[] args) {
		BulkDiscount bd = new BulkDiscount(5, 0.4);
		OtherDiscount od = new OtherDiscount();
		CombineDiscount cd = new CombineDiscount(bd, od);
		System.out.printf("%.2f", cd.computeDiscount(10, 4.5));
	}
}
