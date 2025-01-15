package com.umwix1002.solution.tutorial.Tutorial8.T8Q4;

public class CashPayment extends Payment {
    private final static String PAYMENT_TYPE = "Cash Payment";

    CashPayment(int amount) {
        super(amount);
    }

    @Override
    public void makePayment() {
        System.out.printf("%-15s:", PAYMENT_TYPE);
        super.makePayment();
    }
}
