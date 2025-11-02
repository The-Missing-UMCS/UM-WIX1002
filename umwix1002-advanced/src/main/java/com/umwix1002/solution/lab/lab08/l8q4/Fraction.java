package com.umwix1002.solution.lab.lab08.l8q4;

import lombok.AllArgsConstructor;
import lombok.Data;

import static com.umwix1002.solution.lab.constants.CommonConstant.SLASH;

@Data
@AllArgsConstructor
public class Fraction {

    private int numerator;
    private int denominator;

    private int findGCD(int x, int y) {
        return y == 0 ? x : findGCD(y, x % y);
    }

    public int getGCD() {
        return findGCD(numerator, denominator);
    }

    public String reduce() {
        int gcd = getGCD();
        return (numerator / gcd) + "/" + (denominator / gcd);
    }

    /*
     * They both do the same thing. The difference lies only in the method name.
     */
    public String getSimplestFraction() {
        return reduce();
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
