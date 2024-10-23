package com.umwix1002.solution.lab.lab8.l8q4;

import com.umwix1002.solution.lab.constants.CommonConstant;
import lombok.AllArgsConstructor;
import lombok.Data;

import static com.umwix1002.solution.lab.constants.CommonConstant.ZERO;
import static com.umwix1002.solution.lab.constants.CommonConstant.SLASH;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class Fraction {
    private int numerator;
    private int denominator;

    private int findGCD(int x, int y) {
        return y == ZERO ? x : findGCD(y, x % y);
    }

    public int getGCD() {
        return findGCD(this.numerator, this.denominator);
    }

    public String reduce() {
        int gcd = getGCD();
        return (numerator / gcd) + SLASH + (denominator / gcd);
    }

    @Override
    public String toString() {
        return numerator + SLASH + denominator;
    }
}
