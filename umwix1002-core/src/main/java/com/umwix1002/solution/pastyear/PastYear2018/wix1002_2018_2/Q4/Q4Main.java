package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_2.Q4;

import java.util.Arrays;
import java.util.Scanner;

public class Q4Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the values for a, b, c, d, e and f: ");
            int[] values = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

            LinearEquation eq = new LinearEquation(values[0], values[1], values[2], values[3], values[4], values[5]);
            System.out.println("The equation : ");
            System.out.println(eq + "\n");
            System.out.printf("x = %.0f ; y = %.0f", eq.computeX(), eq.computeY());
        }
    }
}
