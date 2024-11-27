package com.umwix1002.solution.lab.util;

import com.umwix1002.solution.lab.constants.CommonConstant;
import com.umwix1002.solution.lab.util.exception.NegativeValueException;

public class AssertUtil {
    /**
     * Asserts that the specified integer value is greater than or equal to zero.
     *
     * @param val the integer value to check
     * @throws NegativeValueException if the specified value is less than zero
     */
    public static void assertPositive(int val) {
        if (val < CommonConstant.ZERO) {
            throw new NegativeValueException("val=" + val + " is less than 0");
        }
    }

    /**
     * Asserts that the specified double value is greater than or equal to zero.
     *
     * @param val the double value to check
     * @throws NegativeValueException if the specified value is less than zero
     */
    public static void assertPositive(double val) {
        if (val < CommonConstant.ZERO) {
            throw new NegativeValueException("val=" + val + " is less than 0");
        }
    }

    /**
     * Asserts that the specified long value is greater than or equal to zero.
     *
     * @param val the long value to check
     * @throws NegativeValueException if the specified value is less than zero
     */
    public static void assertPositive(long val) {
        if (val < CommonConstant.ZERO) {
            throw new NegativeValueException("val=" + val + " is less than 0");
        }
    }

    /**
     * Asserts that the specified integer value is greater than zero.
     *
     * @param val the integer value to check
     * @throws NegativeValueException if the specified value is less than or equal to zero
     */
    public static void assertNatural(int val) {
        if (val <= CommonConstant.ZERO) {
            throw new NegativeValueException("val=" + val + " is less than or equal to 0");
        }
    }

    /**
     * Asserts that the specified long value is greater than zero.
     *
     * @param val the long value to check
     * @throws NegativeValueException if the specified value is less than or equal to zero
     */
    public static void assertNatural(long val) {
        if (val <= CommonConstant.ZERO) {
            throw new NegativeValueException("val=" + val + " is less than or equal to 0");
        }
    }
}
