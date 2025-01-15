package com.umwix1002.solution.lab.Lab8.L8Q7;

public class Main {
	public static void main(String[] args) {
		System.out.println(new Money(123.47).getNotesAndCoins());
		System.out.println(Money.add(34.56, 45.89).getAmountAsCash());
	}
}