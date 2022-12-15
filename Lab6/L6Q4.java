package com.fyiernzy.Lab6;

public class L6Q4 {
	public static void main(String[] args) {
		System.out.println(findGCD(24, 8));
		System.out.println(findGCD(200, 625));
	}
	
	public static int findGCD(int a, int b) {
		int dividend = (a > b) ? a : b;
		int divisor = (b < a) ? b : a;
		
		if (dividend % divisor == 0)
			return divisor;
		else
			return findGCD(divisor, dividend % divisor);
	}
}
