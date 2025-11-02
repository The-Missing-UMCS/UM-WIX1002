package com.umwix1002.solution.lab.lab06;

import com.umwix1002.solution.lab.util.AssertUtil;

import java.util.stream.IntStream;

/**
 * @author Ng Zhi Yang
 */
public class l6q1c {
    public static void main(String[] args) {
        // Generate triangular numbers from START_INCLUSIVE to END_INCLUSIVE,
        // convert each to a String, and join them with a comma and space.
        // .map function converts the int stream to triangular numbers.
        // .boxed() converts the int stream to a stream of Integer objects.
        System.out.println(IntStream.rangeClosed(1, 20)
            .map(l6q1c::triangular)
            .boxed()
            .toList());
    }

    public static int triangular(int n) {
        AssertUtil.assertPositive(n);
        return n * (n + 1) / 2;
    }
}
