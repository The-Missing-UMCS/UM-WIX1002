package com.umwix1002.solution.lab.lab8.l8q3;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.umwix1002.solution.lab.constants.CommonConstant.HUNDRED;
import static com.umwix1002.solution.lab.constants.CommonConstant.TEN;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class WeightCalculator {
    private double height;
    private int age;

    public double getRecWeight() {
        return ((height - HUNDRED) + ((double) age / TEN)) * 0.9;
    }
}
