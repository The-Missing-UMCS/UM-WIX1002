package com.umwix1002.solution.lab.util;

import static com.umwix1002.solution.lab.constants.CommonConstant.TWO;
import static com.umwix1002.solution.lab.constants.CommonConstant.ZERO;

/**
 * Utility class for mathematical operations. It adds semantic meaning to the
 * operations and provides a more readable code.
 *
 * @author Ng Zhi Yang
 */
public class MyMathUtil {
    /**
     * Checks if a given integer is odd.
     *
     * @param n the integer to check
     * @return true if the integer is odd, false otherwise
     */
    public static boolean isOdd(int n) {
        return n % TWO != ZERO;
    }

    /**
     * Checks if a given integer is even.
     *
     * @param n the integer to check
     * @return true if the integer is even, false otherwise
     */
    public static boolean isEven(int n) {
        return n % TWO == ZERO;
    }

    /**
     * Checks if one integer is divisible by another.
     *
     * @param dividend the integer to be divided
     * @param divisor the integer to divide by
     * @return true if the dividend is divisible by the divisor, false otherwise
     * @throws ArithmeticException if the divisor is zero
     */
    public static boolean isDivisible(int dividend, int divisor) {
        return dividend % divisor == ZERO;
    }

    /**
     * Checks if a given integer is negative.
     *
     * @param n the integer to check
     * @return true if the integer is negative, false otherwise
     */
    public static boolean isNegative(int n) {
        return n < ZERO;
    }
}
