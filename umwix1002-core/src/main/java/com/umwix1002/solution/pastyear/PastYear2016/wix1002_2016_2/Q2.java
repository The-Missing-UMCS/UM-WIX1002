package com.umwix1002.solution.pastyear.PastYear2016.wix1002_2016_2;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a number between 0 and 1000: ");
            int sum = 0;
            for (int val = sc.nextInt(); val > 0; val /= 10) {
                sum += val % 10;
            }
            System.out.println("The sum of the digits is " + sum);
        }
    }
}
