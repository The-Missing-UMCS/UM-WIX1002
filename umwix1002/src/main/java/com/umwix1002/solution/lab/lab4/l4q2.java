package com.umwix1002.solution.lab.lab4;

import com.umwix1002.solution.lab.CommonConstant;

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
            String pattern = "[%10s] Sum = %d\n";
            String[] labels = {"Loop", "Recursion", "Formula"};
            System.out.printf(pattern, labels[0], sumOfTriangularsByLoop(n, l4q2::triangularByLoop));
            System.out.printf(pattern, labels[1], sumOfTriangularsByLoop(n, l4q2::triangularByRecursion));
            System.out.printf(pattern, labels[2], sumOfTriangularsUsingFormula(n));
        }
    }

    /**
     * Calculates the sum of the first n triangular numbers using a formula.
     * For a detailed explanation of the formula, refer to
     * <a href="https://www.quora.com/How-can-you-find-the-sum-of-this-series-1-1-2-1-2-3-Upto-n-terms">
     * this link</a>.
     *
     * @param n The number of triangular terms to sum.
     * @throws IllegalArgumentException if n is less than or equal to 0.
     * @return The sum of the first n triangular numbers.
     */
    public static Integer sumOfTriangularsUsingFormula(Integer n) {
        validate(n);
        return (n * (n + 1) * (n + 2)) / 6;
    }

    /**
     * Calculates the sum of triangular numbers using a loop and a function.
     * This method uses {@code Function<T, T>} from Java 8 for flexibility and modularity.
     * Beginners may find this concept challenging; consider using resources like chatGPT for help.
     *
     * @param n The number of triangular terms to sum.
     * @param func The function to calculate the triangular number.
     * @throws IllegalArgumentException if n is less than or equal to 0.
     * @return The sum of the first n triangular numbers.
     * @see <a href="https://en.wikipedia.org/wiki/Triangular_number">Triangular number</a>
     * @see java.util.function.Function
     */
    public static Integer sumOfTriangularsByLoop(Integer n, Function<Integer, Integer> func) {
        validate(n);
        int sum = 0;
        for (int i = CommonConstant.ONE; i <= n; i++) {
            sum += func.apply(i);
        }
        return sum;
    }

    /**
     * Calculates the nth triangular number using a loop.
     *
     * @param n The position of the triangular number to calculate.
     * @throws IllegalArgumentException if n is less than or equal to 0.
     * @return The nth triangular number.
     */
    private static Integer triangularByLoop(Integer n) {
        int tri = 0;
        for (int i = CommonConstant.ONE; i <= n; i++) {
            tri += i;
        }
        return tri;
    }

    /**
     * Calculates the nth triangular number using recursion.
     *
     * @param n The position of the triangular number to calculate.
     * @throws IllegalArgumentException if n is less than or equal to 0.
     * @return The nth triangular number.
     */
    private static Integer triangularByRecursion(Integer n) {
        validate(n);
        return n < 2 ? n : n + triangularByRecursion(n - 1);
    }

    /**
     * Validates that n is greater than 0, as triangular numbers are defined as sums of positive integers.
     *
     * @param n The number to check; it should be a positive integer.
     * @throws IllegalArgumentException if n is less than or equal to 0.
     */
    private static void validate(Integer n) {
        if (n <= CommonConstant.ZERO) {
            throw new IllegalArgumentException("n must be greater than 0");
        }
    }
}

