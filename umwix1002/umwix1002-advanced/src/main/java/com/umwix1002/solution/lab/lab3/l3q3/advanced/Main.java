package com.umwix1002.solution.lab.lab3.l3q3.advanced;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter the sales volume: ");
            int salesVolume = scanner.nextInt();
            System.out.printf("The commission is %.2f", SalesCondition.getCommissionByVolume(salesVolume));
        }
    }
}
