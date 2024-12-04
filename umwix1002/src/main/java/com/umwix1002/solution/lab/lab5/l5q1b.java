package com.umwix1002.solution.lab.lab5;

import java.util.List;
import java.util.Random;

public class l5q1b {
    public static void main(String[] args) {
        final int NOT_FOUND = -1;
        List<Integer> randomNumbers = new Random().ints(10, 1, 101).boxed().toList();
        System.out.println("min = " + randomNumbers.stream().mapToInt(Integer::intValue).max().orElse(NOT_FOUND));
        System.out.println("max = " + randomNumbers.stream().mapToInt(Integer::intValue).max().orElse(NOT_FOUND));
        System.out.printf("average = %.2f", randomNumbers.stream().mapToInt(Integer::intValue).average().orElse(NOT_FOUND));
    }
}
