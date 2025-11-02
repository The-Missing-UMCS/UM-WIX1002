package com.umwix1002.solution.lab.lab04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l4q1b {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number (integer): ");
            int number = sc.nextInt();
            System.out.println("The factors are: " + getFactors(number));
        }
    }

    public static List<Integer> getFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean divisible = n % i == 0;
            if (divisible) {
                factors.add(i);
            }
        }
        return factors;
    }
}
