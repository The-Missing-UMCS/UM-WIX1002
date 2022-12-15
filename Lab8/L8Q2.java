package com.fyiernzy.Lab8;

public class L8Q2 {
	public static void main(String[] args) {
		BankAccount account = new BankAccount("John Doe", "000000-00-0000", "1234567890", 100.00);
		account.deposit(100);
		account.withdraw(50);
		account.display();
	}
}

class BankAccount {
	private String name;
	private String ic;
	private String passport;
	private double balance;
	
	BankAccount(String name, String ic, String passport, double deposit) {
		this.name = name;
		this.ic = ic;
		this.passport = passport;
		this.balance = deposit;
	}
	
	public void deposit(int amount) {
		if (amount > 0)
			balance += amount;
	}
	
	public void withdraw(int amount) {
		if (amount < balance)
			balance -= amount;
	}
	
	public void display() {
		System.out.printf("Name: %s\nCurrent Balance: %.2f", name, balance);
	}
}
