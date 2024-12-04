package com.umwix1002.solution.lab.lab5;

import com.umwix1002.solution.lab.constants.CommonConstant;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l5q3 {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of employee: ");
            int n = sc.nextInt();
            int[][] hours = new int[n][7];
            int[] sum = new int[n];
            
            String[] labels = {"Day 1", "Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Total"};

            // It may seem challenging at first, but it's worthwhile.
            // This design allows for easy future extensions to add more columns or rows without significant code changes.
            String header = CommonConstant.SPACE.repeat(18) + Arrays.toString(Arrays.stream(labels)
                    .map(label -> String.format("%8s", label))
                    .toArray(String[]::new));
            System.out.println(header);
            
            for (int i = CommonConstant.ZERO; i < hours.length; i++) {
                System.out.printf("%5s%2d", "Employee ", (i + CommonConstant.ONE));
                for (int j = CommonConstant.ZERO; j < hours[i].length; j++) {
                    hours[i][j] = (int) (Math.random() * 8 + CommonConstant.ONE);
                    System.out.printf("%5d %2s", hours[i][j], CommonConstant.SPACE);
                    sum[i] += hours[i][j];
                }
                System.out.printf("%6s", sum[i]);
                System.out.println();
            }
        }
    }
}
