package com.umwix1002.solution.lab.lab8.l8q2;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.setName("John Doe");
        account.deposit(1000);
        account.withdraw(500);
        System.out.println(account);
    }
}
