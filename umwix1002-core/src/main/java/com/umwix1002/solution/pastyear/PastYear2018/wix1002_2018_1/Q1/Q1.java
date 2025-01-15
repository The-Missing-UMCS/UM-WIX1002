package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_1.Q1;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int sum = 0;
            while (true) {
                System.out.print("Enter an integer number, -1 to quit: ");
                int num = scanner.nextInt();
                if (num == -1) {
                    break;
                }
                System.out.printf("The number is an %s number%n", num % 2 == 0 ? "even" : "odd");
                sum += num;
            }
            System.out.printf("The sum of all integer number(s) is : %5d%n", sum);
        }
    }
}
