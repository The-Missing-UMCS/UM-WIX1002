package com.umwix1002.solution.pastyear.PastYear2025;

import java.util.Scanner;

public class py25q1b {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the scores for 5 courses:");
        int numOfCourses = 5;
        double[] scores = new double[numOfCourses];

        // 1. Get all input scores
        for(int i = 0; i < 5; i++) {
            scores[i] = getInputScore(i + 1);
        }

        // 2. Calculate the aggregated values
        double totalScore = 0;
        for (double score : scores) {
            totalScore += score;
        }
        double averageScore = totalScore / numOfCourses;

        // 3. Display the results
        System.out.printf("Average score: %.2f%n", averageScore);
        System.out.printf("Grades: %s%n", grade(averageScore));
    }

    private static double getInputScore(int i) {
        double score;
        while (true) {
            System.out.print("Course " + i + " score: ");
            try {
                score = SCANNER.nextDouble();
                if (score >= 0 && score <= 100) {
                    break;
                }
                System.out.println("Invalid score. Please enter a score between 0 and 100.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid score. Please enter a score between 0 and 100.");
            }
        }
        return score;
    }


    private static char grade(double score) {
        if (score < 0 || score > 100)
            throw new IllegalArgumentException("Score must be between 0 and 100");

        return switch ((int) ((score - 50) / 10)) {
            case 4, 5 -> 'A';
            case 3 -> 'B';
            case 2 -> 'C';
            case 1 -> 'D';
            default -> 'F';
        };
    }
}
