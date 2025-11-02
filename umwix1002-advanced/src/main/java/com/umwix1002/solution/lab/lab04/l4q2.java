package com.umwix1002.solution.lab.lab04;

import java.util.Scanner;
import java.util.function.Function;

/**
 * @author Ng Zhi Yang
 */
public class l4q2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            final int n = sc.nextInt();
            String pattern = "[%10s] Sum = %d%n";
            System.out.printf(pattern, "Loop", sumOfTriangularByLoop(n, l4q2::triangularByLoop));
            System.out.printf(pattern, "Recursion", sumOfTriangularByLoop(n, l4q2::triangularByRecursion));
            System.out.printf(pattern, "Formula", sumOfTriangularUsingFormula(n));
        }
    }

    public static Integer sumOfTriangularUsingFormula(Integer n) {
        validate(n);
        return (n * (n + 1) * (n + 2)) / 6;
    }

    public static Integer sumOfTriangularByLoop(Integer n, Function<Integer, Integer> func) {
        validate(n);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += func.apply(i);
        }
        return sum;
    }

    private static Integer triangularByLoop(Integer n) {
        int tri = 0;
        for (int i = 1; i <= n; i++) {
            tri += i;
        }
        return tri;
    }

    private static Integer triangularByRecursion(Integer n) {
        validate(n);
        return n < 2 ? n : n + triangularByRecursion(n - 1);
    }

    private static void validate(Integer n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
    }
}

