package com.umwix1002.solution.lab.lab08.l8q7.l8q7a;

public class Main {
	public static void main(String[] args) {
		System.out.println(new Money(123.47).getNotesAndCoins());
		System.out.println(Money.add(34.56, 45.89).getAmountAsCash());
	}
}