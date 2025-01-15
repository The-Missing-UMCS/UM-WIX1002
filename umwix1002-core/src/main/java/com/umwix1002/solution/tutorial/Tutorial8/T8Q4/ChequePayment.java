package com.umwix1002.solution.tutorial.Tutorial8.T8Q4;

public class ChequePayment extends Payment {
    private final static String PAYMENT_TYPE = "Cheque Payment";
    String chequeNumber;

    ChequePayment(int amount, String chequeNumber) {
        super(amount);
        this.chequeNumber = chequeNumber;
    }

    @Override
    public void makePayment() {
        System.out.printf("%-15s:", PAYMENT_TYPE);
        super.makePayment();
    }
}
