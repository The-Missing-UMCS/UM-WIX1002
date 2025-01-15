package com.umwix1002.solution.tutorial.Tutorial10.L10T1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BulkDiscount implements DiscountPolicy {
    private final int minimum;
    private final double discountRate;

    @Override
    public double computeDiscount(int count, double itemCost) {
        boolean hasDiscount = count > this.minimum;
        return (count * itemCost * (hasDiscount ? (1 - discountRate) : 1));
    }
}
