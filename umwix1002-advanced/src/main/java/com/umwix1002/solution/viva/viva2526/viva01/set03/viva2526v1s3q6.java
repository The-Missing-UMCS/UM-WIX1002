package com.umwix1002.solution.viva.viva2526.viva01.set03;

import java.util.Scanner;

public class viva2526v1s3q6 {

    public static void main(String[] args) {
        String input = """
            1
            9500
            10200
            8700
            12000
            9800
            10400
            9100
            """;

        try (Scanner scanner = new Scanner(input)) {
            int testcases = scanner.nextInt();

            for (int t = 0; t < testcases; t++) {

                int totalSteps = 0;
                int maxSteps = -1;
                int mostActiveDay = 0;

                // 1. Get user input
                for (int day = 1; day <= 7; day++) {
                    int steps;
                    while (true) {
                        steps = scanner.nextInt();
                        if (steps >= 0 && steps <= 50000) {
                            break;
                        }
                        System.out.println(
                            "Invalid input! Please enter a number between 0 and 50,000.");
                    }

                    totalSteps += steps;

                    if (steps > maxSteps) {
                        maxSteps = steps;
                        mostActiveDay = day;
                    }
                }

                // 2. Display result
                double average = totalSteps / 7.0;
                String performanceMessage;
                if (totalSteps >= 70000) {
                    performanceMessage = "Amazing! You’re smashing your goals!";
                } else if (totalSteps >= 40000) {
                    performanceMessage = "Good job! Keep pushing for consistency!";
                } else {
                    performanceMessage = "You can do better, small steps daily make a big difference!";
                }

                String healthTip = switch ((int) (Math.random() * 3 + 1)) {
                    case 1 -> "Stay hydrated and stretch after walks!";
                    case 2 -> "Consistency is key — even 10-minute walks matter!";
                    case 3 -> "Take short breaks to stand and move during long sitting!";
                    default -> "Keep prioritizing your health!";
                };

                System.out.printf("""
                        Total Steps This Week: %d
                        Average Daily Steps: %.2f
                        Most Active Day: Day %d with %d steps
                        %s
                        Tip of the Day: %s
                        """, totalSteps, average, mostActiveDay, maxSteps, performanceMessage,
                    healthTip);
            }
        }
    }
}
