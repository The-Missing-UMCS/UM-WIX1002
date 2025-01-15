package com.umwix1002.solution.pastyear.PastYear2016.wix1002_2016_2;

import java.util.Scanner;

import static java.lang.Math.*;

public class Q4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the value of n for a regular polygon, n: ");
            int n = sc.nextInt();
            System.out.print("Enter the length of a particular side of the regular polygon (in meter), s: ");
            int s = sc.nextInt();
            System.out.printf("The area is: %.2f squared meters.", area(n, s));
        }
    }

    public static double area(int n, double s) {
        return (n * pow(s, 2)) / (4 * tan(toRadians((double) 180 / n)));
    }
}
