package com.fyiernzy.Lab8;

public class L8Q4 {
	public static void main(String[] args) {
		new Fraction(200, 625).showSimplest();
	}
}

class Fraction {
	int numerator;
	int denominator;
	int gcd;
	
	Fraction(int numerator, int denominator){
		this.numerator = numerator;
		this.denominator = denominator;
		this.gcd = findGCD(numerator, denominator);
	}
	
	public void setNumerator(int n) {
		this.numerator = n;
	}
	
	public void setDenominator(int n) {
		this.denominator = n;
	}
	
	public void getNumerator(int n) {
		this.numerator = n;
	}
	
	public void getDenominator(int n) {
		this.denominator = n;
	}
	
	public int findGCD(int x, int y) {
		int a, b;
		a = (x > y) ? x : y;
		b = (x < y) ? x : y;
		
		if (a % b == 0)
			return b;
		else
			return findGCD(b, a % b);
	}
	
	public void showSimplest() {
		System.out.printf("%d / %d", (numerator / gcd), (denominator / gcd));
	}
}