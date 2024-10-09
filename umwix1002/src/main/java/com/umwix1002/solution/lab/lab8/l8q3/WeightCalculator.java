package com.umwix1002.solution.lab.lab8.l8q3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class WeightCalculator {
    private double height;
    private int age;

    public double getRecWeight() {
        return ((height - 100) + ((double) age / 10)) * 0.9;
    }
}
