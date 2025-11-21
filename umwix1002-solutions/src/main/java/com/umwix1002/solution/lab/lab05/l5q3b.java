package com.umwix1002.solution.lab.lab05;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Ng Zhi Yang
 */
public class l5q3b {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // 1. Get the number of employees from the user.
            System.out.print("Enter number of employee: ");
            int n = sc.nextInt();
            int[][] hours = new int[n][7];
            int[] sum = new int[n];

            String[] labels = {"Day 1", "Day 2", "Day 3", "Day 4", "Day 5", "Day 6", "Day 7", "Total"};
            final String format = "%8s  |";

            // 2. Display the header of the table.
            String header = " ".repeat(15) + Arrays.stream(labels)
                .map(label -> String.format(format, label))
                .collect(Collectors.joining());
            System.out.println(header);

            // 3. Generate random hours for each employee and display the table.
            for (int i = 0; i < hours.length; i++) {
                System.out.printf("%5s%2d  | ", "Employee ", (i + 1));
                for (int j = 0; j < hours[i].length; j++) {
                    hours[i][j] = (int) (Math.random() * 8 + 1);
                    sum[i] += hours[i][j];
                    System.out.printf(format, hours[i][j]);
                }
                System.out.printf(format + "%n", sum[i]);
            }
        }
    }
}
