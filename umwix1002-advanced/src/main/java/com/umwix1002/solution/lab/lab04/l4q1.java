package com.umwix1002.solution.lab.lab04;

import java.util.Scanner;

public class l4q1a {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number (integer): ");
            int number = sc.nextInt();
            System.out.print("The factors are: ");
            for (int i = 1; i <= number; i++) {
                boolean isDivisible = number % i == 0;
                if (isDivisible) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
