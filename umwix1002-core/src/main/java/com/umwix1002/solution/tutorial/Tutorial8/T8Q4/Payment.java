package com.umwix1002.solution.tutorial.Tutorial8.T8Q4;

public class Payment {
    protected int amount;

    protected Payment(int amount) {
        this.amount = amount;
    }

    public void makePayment() {
        System.out.println("Your payment is successfull!");
    }
}
