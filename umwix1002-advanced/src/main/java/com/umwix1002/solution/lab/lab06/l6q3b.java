package com.umwix1002.solution.lab.lab06;

import com.umwix1002.solution.lab.util.AssertUtil;

import java.util.Random;

import static com.umwix1002.solution.lab.constants.CommonConstant.TEN;
import static com.umwix1002.solution.lab.constants.CommonConstant.ZERO;

/**
 * This implementation uses {@code long} to accommodate larger numbers. However, if you encounter
 * an error such as:
 * <pre>
 * Exception in thread "main" java.util.InputMismatchException: For input string: "2183982193829138923"
 * </pre>
 * it indicates that the number exceeds the range of {@code long}.
 * To resolve this issue, consider using the {@link java.math.BigInteger} class instead.
 *
 * @author Ng Zhi Yang
 */
public class l6q3b {
    private static final int SIZE = 10;
    private static final int INCLUSIVE_START = 100_000;
    private static final int EXCLUSIVE_END = 100_000_001;

    public static void main(String[] args) {
        new Random()
            .longs(SIZE, INCLUSIVE_START, EXCLUSIVE_END)
            .forEach(val -> System.out.printf("input=%15d, reverse=%15d%n", val, reverse(val)));
    }

    public static long reverse(long val) {
        AssertUtil.assertPositive(val);
        long result = ZERO;
        while (val != ZERO) {
            result = result * TEN + val % TEN;
            val /= TEN;
        }
        return result;
    }
}
