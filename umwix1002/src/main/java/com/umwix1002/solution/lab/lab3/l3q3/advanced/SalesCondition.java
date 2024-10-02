package com.umwix1002.solution.lab.lab3.l3q3.advanced;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * @author Ng Zhi Yang
 */

@Getter
public enum SalesCondition {
    VOLUME_OVER_1K(i -> i > 1000, 0.15),
    VOLUME_BETWEEN_500_AND_1K(i -> i >= 500 && i <= 1000, 0.10),
    VOLUME_UNDER_500(i -> i < 500, 0.05);

    private final Predicate<Integer> condition;
    private final Double commission;

    SalesCondition(Predicate<Integer> condition, Double commission) {
        this.condition = condition;
        this.commission = commission;
    }

    public static Double getCommissionByVolume(Integer volume) {
        return Arrays.stream(SalesCondition.values())
            .filter(salesCondition -> salesCondition.getCondition().test(volume))
            .findFirst()
            .map(SalesCondition::getCommission)
            .orElseThrow(() -> new IllegalArgumentException("No commission found for volume " + volume));
    }


}
