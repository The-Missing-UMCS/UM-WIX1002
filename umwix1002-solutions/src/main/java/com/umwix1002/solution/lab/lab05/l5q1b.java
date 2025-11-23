package com.umwix1002.solution.lab.lab05;

import java.util.List;
import java.util.Random;

public class l5q1b {
    public static void main(String[] args) {
        List<Integer> randomNumbers = new Random().ints(10, 1, 101).boxed().toList();

        int min = randomNumbers.stream()
            .mapToInt(Integer::intValue)
            .max()
            .orElse(-1);
        System.out.printf("max = %d%n", min);

        int max = randomNumbers.stream()
            .mapToInt(Integer::intValue)
            .max()
            .orElse(-1);
        System.out.printf("max = %d%n", max);

        double avg = randomNumbers.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(-1);
        System.out.printf("average = %.2f%n", avg);
    }
}
