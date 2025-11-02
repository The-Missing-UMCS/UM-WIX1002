package com.umwix1002.solution.lab.lab09.l9q3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author Ng Zhi Yang
 */

@Getter
@RequiredArgsConstructor
public enum CreditHour {
    CREDIT_HOUR_1(150, 3),
    CREDIT_HOUR_2(100, 2),
    CREDIT_HOUR_3(50, 1.5),
    CREDIT_HOUR_4(0, 1);
    
    private final int minStudentCount;
    private final double multiplier;
    
    public static CreditHour getCreditHourByStudentCount(int studentCount) {
        return Arrays.stream(CreditHour.values())
            .filter(creditHour -> studentCount >= creditHour.getMinStudentCount())
            .findFirst()
            .orElse(CREDIT_HOUR_4);
    }
}
