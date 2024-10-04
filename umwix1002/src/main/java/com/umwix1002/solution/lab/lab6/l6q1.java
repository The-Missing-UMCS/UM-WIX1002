package com.umwix1002.solution.lab.lab6;

import com.umwix1002.solution.lab.CommonConstant;
import com.umwix1002.solution.lab.CommonUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.umwix1002.solution.lab.CommonConstant.COMMA;
import static com.umwix1002.solution.lab.CommonConstant.SPACE;

/**
 * @author Ng Zhi Yang
 */
public class l6q1 {
    private static final int START_INCLUSIVE = CommonConstant.ONE;
    private static final int END_INCLUSIVE = 20;

    public static void main(String[] args) {
        // Generate triangular numbers from START_INCLUSIVE to END_INCLUSIVE,
        // convert each to a String, and join them with a comma and space.
        // .map function converts the int stream to triangular numbers.
        // .boxed() converts the int stream to a stream of Integer objects.
        System.out.println(IntStream.rangeClosed(START_INCLUSIVE, END_INCLUSIVE)
            .map(l6q1::triangular)
            .boxed()
            .toList());
    }

    /**
     * Calculates the triangular number for a given positive integer n.
     * A triangular number is the sum of the integers from 1 to n, which can
     * also be expressed as n * (n + 1) / 2.
     *
     * @param n the positive integer for which to calculate the triangular number
     * @return the triangular number corresponding to the input n
     * @throws IllegalArgumentException if n is not a positive integer
     */
    public static int triangular(int n) {
        CommonUtils.checkPositiveInteger(n);
        return n * (n + CommonConstant.ONE) / 2;
    }
}
