package com.umwix1002.solution.tutorial.Tutorial10.L10T1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CombineDiscount implements DiscountPolicy {
    private final DiscountPolicy dp1;
    private final DiscountPolicy dp2;

    @Override
    public double computeDiscount(int count, double itemCost) {
        return (Math.max(dp1.computeDiscount(count, itemCost), dp2.computeDiscount(count, itemCost)));
    }
}
