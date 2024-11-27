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
        return !isDivisible(n, TWO);
    }

    /**
     * Checks if a given integer is even.
     *
     * @param n the integer to check
     * @return true if the integer is even, false otherwise
     */
    public static boolean isEven(int n) {
        return isDivisible(n, TWO);
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

    public static boolean isNegative(int n) {
        return n < ZERO;
    }
    
    public static boolean isNegative(long n) {
        return n < ZERO;
    }

    public static boolean isNegative(double n) {
        return n < ZERO;
    }

    /**
     * Check if an integer is greater than zero.
     * @param n the integer to check
     * @return true if the integer is positive, false otherwise
     */
    public static boolean isPositive(int n) {
        return n > ZERO;
    }

    /**
     * Check if a double is greater than zero.
     * @param n the double to check
     * @return true if the double is positive, false otherwise
     */
    public static boolean isPositive(double n) {
        return n > ZERO;
    }

    /**
     * Check if a long is greater than zero.
     * @param n the long to check
     * @return true if the long is positive, false otherwise
     */
    public static boolean isPositive(long n) {
        return n > ZERO;
    }

    /**
     * Check if an integer is greater or equal to zero.
     * @param n the integer to check
     * @return true if the integer is positive, false otherwise
     */
    public static boolean isNonNegative(int n) {
        return n >= ZERO;
    }

    /**
     * Check if a long is greater or equal to zero.
     * @param n the long to check
     * @return true if the long is positive, false otherwise
     */
    public static boolean isNonNegative(long n) {
        return n >= ZERO;
    }

    /**
     * Check if a double is greater or equal to zero.
     * @param n the double to check
     * @return true if the double is positive, false otherwise
     */
    public static boolean isNonNegative(double n) {
        return n >= ZERO;
    }

    /**
     * Checks if a given integer is prime.
     *
     * @param n the integer to check
     * @return true if the integer is prime, false otherwise
     */
    public static boolean isPrime(int n) {
        if (n == TWO) {
            return true;
        }
        
        if (n < TWO || MyMathUtil.isEven(n)) {
            return false;
        }
        
        for(int i = 3; i <= Math.sqrt(n); i += TWO) {
            if (MyMathUtil.isDivisible(n, i)) {
                return false;
            }
        }
        return true;
    }
}
