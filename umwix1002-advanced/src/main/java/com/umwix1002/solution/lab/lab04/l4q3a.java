package com.umwix1002.solution.lab.lab04;

import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l4q3a {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int num, n = 0, sum = 0, squaredSum = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            while (true) {
                System.out.print("Enter a score [negative score to quit]: ");
                if ((num = sc.nextInt()) < 0) break;
                sum += num;
                squaredSum += num * num;
                n++;
                if (num < min) min = num;
                if (num > max) max = num;
            }

            double average = (double) sum / n;
            double variance = (squaredSum - Math.pow(sum, 2) / n) / (double) (n - 1);
            double standardDeviation = Math.sqrt(variance);

            System.out.println("Minimum Score: " + min);
            System.out.println("Maximum Score: " + max);
            System.out.printf("Average Score: %.2f%n", average);
            System.out.printf("Standard Deviation: %.2f%n", standardDeviation);
        }
    }
}
