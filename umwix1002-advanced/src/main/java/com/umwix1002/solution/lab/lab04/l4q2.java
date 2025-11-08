package com.umwix1002.solution.lab.lab04;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Ng Zhi Yang
 */
public class l4q2 {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the value of n: ");
            int n = sc.nextInt();
            String pattern = "[%-15s] Sum = %d%n";

            int sum;

            // 1. Calculate the sum of triangular numbers using formula
            sum = (n * (n + 1) * (n + 2)) / 6;
            System.out.printf(pattern, "Formula", sum);

            // 2. Calculate the sum of triangular numbers using for loop
            sum = 0;
            for (int i = 1; i <= n; i++) {
                int triangularNumber = 0;
                for (int j = 1; j <= i; j++) {
                    triangularNumber += j;
                }
                sum += triangularNumber;
            }
            System.out.printf(pattern, "Loop (For)", sum);

            // 3. Calculate the sum of triangular numbers using while loop
            sum = 0;
            int sumIndex = 0;
            while (++sumIndex <= n) {
                int triangularNumber = 0;

                int numberIndex = 0;
                while (++numberIndex <= sumIndex) {
                    triangularNumber += numberIndex;
                }

                sum += triangularNumber;
            }
            System.out.printf(pattern, "Loop (While)", sum);

            // 4. Calculate the sum of triangular numbers using recursion
            sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += triangularNumber(i);
            }
            System.out.printf(pattern, "Recursion", sum);

            // 5. Calculate the sum of triangular numbers using functional programming (Stream)
            sum = IntStream.rangeClosed(1, n)
                .map(number -> IntStream.rangeClosed(1, number).sum())
                .sum();
            System.out.printf(pattern, "Stream", sum);
        }
    }

    private static Integer triangularNumber(int n) {
        return n <= 1 ? n : n + triangularNumber(n - 1);
    }
}

