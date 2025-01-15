package com.umwix1002.solution.pastyear.PastYear2020.Q5.domain;

import lombok.Getter;

@Getter
public class SpecialDelivery extends Delivery {
    private final boolean weekend;
    private final boolean nightTime;

    public SpecialDelivery(String sender, String recipient, double weight, boolean nightTime, boolean weekend) {
        super(sender, recipient, weight);
        this.nightTime = nightTime;
        this.weekend = weekend;
    }

    @Override
    public double calculateTotalCost() {
        double baseCost = super.calculateTotalCost();
        baseCost += nightTime ? 50 : 0;
        return weekend ? baseCost * 1.2 : baseCost;
    }

    @Override
    public String toString() {
        return super.toString() + (weekend ? "Weekend Delivery\n" : "") + (nightTime ? "Night Time Delivery\n" : "");
    }
}
