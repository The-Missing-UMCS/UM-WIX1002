package com.umwix1002.solution.lab.lab2;

import java.util.List;
import java.util.Random;

/**
 * @author Ng Zhi Yang
 */
public class l2q3b {
    public static void main(String[] args) {
        List<Integer> numbers = new Random().ints(3, 10, 51).boxed().toList();
        System.out.println(numbers);
        System.out.printf("sum: %d%n", numbers.stream().mapToInt(Integer::intValue).sum());
        System.out.printf("average: %.2f%n", numbers.stream().mapToInt(Integer::intValue).average().orElse(0));
    }
}
