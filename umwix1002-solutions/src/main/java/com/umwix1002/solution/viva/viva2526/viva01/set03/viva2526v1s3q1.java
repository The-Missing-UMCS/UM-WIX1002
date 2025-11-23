package com.umwix1002.solution.viva.viva2526.viva01.set03;

import java.util.Random;
import java.util.Scanner;

public class viva2526v1s3q1 {

    public static void main(String[] args) {
        String input = """
            4
            6 8 2
            5 7 2
            10 6 4
            20 2 1
            """;

        try (Scanner scanner = new Scanner(input)) {
            int testcases = scanner.nextInt();

            for (int i = 0; i < testcases; i++) {
                double hoursStudied = scanner.nextDouble();
                System.out.println("Enter hours studied: " + hoursStudied);
                double hoursSlept = scanner.nextDouble();
                System.out.println("Enter hours slept: " + hoursSlept);
                int breaks = scanner.nextInt();
                System.out.println("Enter breaks taken: " + breaks);

                // Validate inputs
                boolean valid = (hoursStudied >= 0 && hoursStudied <= 24)
                                && (hoursSlept >= 0 && hoursSlept <= 24)
                                && breaks >= 0;

                if (!valid) {
                    System.out.println(
                        "Error: Invalid input detected! Values out of realistic range.");
                    System.out.println();
                    continue;
                }

                double score = (hoursStudied * 10) - (breaks * 2);

                System.out.println("Your productivity score is: " + score);
                if (score > 60) {
                    System.out.println("Excellent! Keep up the great work!");
                } else if (score >= 30) {
                    System.out.println("Good effort, but balance your breaks!");
                } else {
                    System.out.println("Try to plan your day better!");
                }

                // Tip of the Day (simple switch)
                Random random = new Random();
                int tipNumber = random.nextInt(5);

                System.out.print("Tip of the Day: ");
                switch (tipNumber) {
                    case 0:
                        System.out.println("Stay hydrated while studying!");
                        break;
                    case 1:
                        System.out.println("Short breaks can boost your focus!");
                        break;
                    case 2:
                        System.out.println("A clean study space improves productivity.");
                        break;
                    case 3:
                        System.out.println("Review notes before sleeping!");
                        break;
                    default:
                        System.out.println("Set small goals and reward yourself!");
                }

                System.out.println();
            }
        }
    }
}
