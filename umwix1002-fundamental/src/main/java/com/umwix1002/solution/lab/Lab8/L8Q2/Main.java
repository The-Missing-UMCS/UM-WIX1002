package com.umwix1002.solution.lab.Lab8.L8Q2;

public class Main {
	public static void main(String[] args) {
		BankAccount account = new BankAccount("John Doe", "000000-00-0000", "1234567890", 100.00);
		account.deposit(100);
		account.withdraw(50);
		account.display();
	}
}
