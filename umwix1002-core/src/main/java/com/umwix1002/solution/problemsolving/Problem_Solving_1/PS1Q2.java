package com.umwix1002.solution.problemsolving.Problem_Solving_1;

import java.util.Scanner;

public class PS1Q2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String ans;
            double total = 0;

            while (true) {
                System.out.print("Enter the type of durian. [Quit] to terminate: ");
                ans = scanner.nextLine();

                if ("Quit".equals(ans)) {
                    break;
                }

                int price = switch (ans) {
                    case "MK" -> 25;
                    case "HL" -> 22;
                    case "D24" -> 20;
                    case "UM" -> 18;
                    default -> 0;
                };

                System.out.print("Enter sales in kg: ");
                total += price * scanner.nextDouble();
                scanner.nextLine();
            }

            System.out.printf("Total sales: %.2f", total);
        }
    }
}