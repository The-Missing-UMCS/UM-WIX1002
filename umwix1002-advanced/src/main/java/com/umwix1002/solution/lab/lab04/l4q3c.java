package com.umwix1002.solution.lab.lab04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l4q3c {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<Integer> arr = new ArrayList<>();
            int num;
            while (true) {
                System.out.print("Enter a score [negative score to quit]: ");
                if ((num = sc.nextInt()) < 0) {
                    break;
                }
                arr.add(num);
            }
            System.out.println("Minimum Score: " + findMinValue(arr));
            System.out.println("Maximum Score: " + findMaxValue(arr));
            System.out.printf("Average Score: %.2f%n", calculateAverage(arr));
            System.out.printf("Standard Deviation: %.2f%n", calculateStandardDeviation(arr));
        }
    }

    public static int findMinValue(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            if (i < min) {
                min = arr.get(i);
            }
        }
        return min;
    }

    public static int findMaxValue(List<Integer> arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = arr.get(i);
            }
        }
        return max;
    }

    public static int calculateSum(List<Integer> arr) {
        int total = 0;
        for (int i : arr) {
            total += i;
        }
        return total;
    }

    public static double calculateAverage(List<Integer> arr) {
        return calculateSum(arr) / (double) arr.size();
    }

    public static int calculatedSquaredSum(List<Integer> arr) {
        int sum = 0;
        for (int i : arr) {
            sum += (int) (Math.pow(i, 2));
        }
        return sum;
    }

    public static double calculateStandardDeviation(List<Integer> arr) {
        int n = arr.size();
        double squaredAverage = Math.pow(calculateAverage(arr), 2);
        double variance = (calculatedSquaredSum(arr) - (squaredAverage / n)) / (double) (n - 1);
        return Math.sqrt(variance);
    }
}
