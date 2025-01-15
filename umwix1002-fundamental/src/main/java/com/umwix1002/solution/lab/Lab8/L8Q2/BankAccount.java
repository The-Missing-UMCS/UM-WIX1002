package com.umwix1002.solution.lab.Lab8.L8Q2;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BankAccount {
    private String name;
    private String ic;
    private String passport;
    private double balance;

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
