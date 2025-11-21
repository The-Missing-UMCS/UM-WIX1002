package com.umwix1002.solution.tutorial.Tutorial10.L10T1;

public class OtherDiscount implements DiscountPolicy {
    @Override
    public double computeDiscount(int count, double itemCost) {
        double discount = 0.0;
        if (count > 8) discount = 0.3;
        else if (count >= 6) discount = 0.2;
        else if (count >= 3) discount = 0.1;
        return (count * itemCost * (1 - discount));
    }
}
