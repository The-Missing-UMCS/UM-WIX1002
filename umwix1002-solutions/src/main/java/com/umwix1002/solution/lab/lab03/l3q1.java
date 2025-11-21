package com.umwix1002.solution.lab.lab03;

import java.util.Scanner;

public class l3q1 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter two number: ");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            System.out.print("Enter the operator: ");
            char operator = scanner.next().charAt(0);
            int result = switch (operator) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> num1 / num2;
                case '%' -> num1 % num2;
                default -> 0;
            };
            System.out.printf("%d %c %d is %d", num1, operator, num2, result);
        }
    }
}
