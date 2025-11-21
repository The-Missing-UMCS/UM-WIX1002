package com.umwix1002.solution.problemsolving.ps2223s02;

import java.util.Scanner;

public class PS2Q2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int points = 0;
            int numOfQuestion = 0;

            while (true) {
                System.out.print("Enter a number (-1 to quit): ");
                int dividend = scanner.nextInt();

                if (dividend < 0) {
                    break;
                }

                numOfQuestion++;
                System.out.print("Enter a factor: ");
                int factor = scanner.nextInt();

                System.out.printf("%d is a factor of %d? (true/false): ", factor, dividend);
                boolean answer = scanner.nextBoolean();
                boolean isAnswerCorrect = (dividend % factor == 0) == answer;

                if (isAnswerCorrect) {
                    points++;
                    System.out.println("Your answer is correct.");
                } else {
                    System.out.println("Your answer is incorrect.");
                }
            }
            System.out.printf("The final score is %d/%d", points, numOfQuestion);
        }
    }
}
