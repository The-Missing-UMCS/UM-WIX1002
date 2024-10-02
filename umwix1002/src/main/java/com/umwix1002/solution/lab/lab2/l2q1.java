package com.umwix1002.solution.lab.lab2;

import java.util.Scanner;

public class l2q1 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the degree Fahrenheit: ");
            double fah = scanner.nextDouble();
            double cel = (fah - 32) / 18;
            System.out.printf("%.2f degree Fahrenheit is %.2f degree Celsius", fah, cel);
        }
    }
}
