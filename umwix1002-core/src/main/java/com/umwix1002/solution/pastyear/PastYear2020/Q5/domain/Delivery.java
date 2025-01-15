package com.umwix1002.solution.pastyear.PastYear2020.Q5.domain;

public class Delivery {
    protected static final double[] RANGE = {5.0, 15.0, 30.0};
    protected static final double[] VALUE = {2.8, 5.2, 7.0, 8.6};

    private final String sender;
    private final String recipient;
    private final double weight;

    public Delivery(String sender, String recipient, double weight) {
        this.sender = sender;
        this.recipient = recipient;
        this.weight = weight;
    }

    public double calculateTotalCost() {
        double remainingWeight = this.weight;
        double cost = 0;

        for (int i = 0; i < RANGE.length; i++) {
            double applicableWeight = Math.min(remainingWeight, RANGE[i]);
            cost += applicableWeight * VALUE[i];
            remainingWeight -= RANGE[i];
            if (remainingWeight <= 0) break;
        }

        if (remainingWeight > 0) {
            cost += remainingWeight * VALUE[3];
        }

        return cost;
    }

    @Override
    public String toString() {
        return String.format("From: %s To: %s%nWeight of Package: %.2f%nShipping Cost: %.2f%n", sender, recipient, weight, calculateTotalCost());
    }
}