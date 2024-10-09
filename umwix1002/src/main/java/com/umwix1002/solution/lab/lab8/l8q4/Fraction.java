package com.umwix1002.solution.lab.lab8.l8q4;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class Fraction {
    private int numerator;
    private int denominator;

    private int findGCD(int x, int y) {
        return y == 0 ? x : findGCD(y, x % y);
    }

    public int getGCD() {
        return findGCD(this.numerator, this.denominator);
    }

    public String reduce() {
        int gcd = getGCD();
        return (numerator / gcd) + "/" + (denominator / gcd);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
