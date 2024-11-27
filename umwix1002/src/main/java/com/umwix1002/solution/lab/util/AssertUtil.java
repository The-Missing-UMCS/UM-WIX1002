package com.umwix1002.solution.lab.util;

import com.umwix1002.solution.lab.constants.CommonConstant;
import com.umwix1002.solution.lab.util.exception.NegativeValueException;

/**
 * @author Ng Zhi Yang
 */
public class AssertUtil {
    public static void assertNonNegative(int val) {
        assertNonNegative(val, "val=" + val + " is less than 0");
    }

    public static void assertNonNegative(int val, String message) {
        assertTrue(MyMathUtil.isNonNegative(val), message, NegativeValueException.class);
    }

    public static void assertNonNegative(long val) {
        assertNonNegative(val, "val=" + val + " is less than or equal to 0");
    }

    public static void assertNonNegative(long val, String message) {
        assertTrue(MyMathUtil.isNonNegative(val), message, NegativeValueException.class);
    }

    public static void assertNonNegative(double val) {
        assertTrue(MyMathUtil.isNonNegative(val), "val=" + val + " is less than or equal to 0");
    }

    public static void assertNonNegative(double val, String message) {
        assertTrue(MyMathUtil.isNonNegative(val), message, NegativeValueException.class);
    }

    public static void assertPositive(int val) {
        assertTrue(MyMathUtil.isPositive(val), "val=" + val + " is less than or equal to 0", IllegalArgumentException.class);
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
        assertTrue(MyMathUtil.isPositive(val), "val=" + val + " is less than or equal to 0", IllegalArgumentException.class);
    }

    public static void assertTrue(boolean condition) {
        assertTrue(condition, "condition is false!");
    }

    public static void assertTrue(boolean condition, String message) {
        assertTrue(condition, message, RuntimeException.class);
    }

    public static void assertTrue(boolean condition, String message, Class<? extends Exception> exceptionClass) {
        if(!condition) {
            try {
                throw exceptionClass.getConstructor(String.class).newInstance(message);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
