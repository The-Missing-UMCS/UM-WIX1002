package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q1;

import java.util.Scanner;

public class Q1a {
    public static final String INVALID_MSG = "Invalid value {%s}. Please enter an integer value.%n";
    public static final String RESULT = "Positive: %d, Negative: %d, Zeros: %d";
    private static final String PROMPT_MESSAGE = "Int value(s) (X to quit): ";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] counts = new int[]{0, 0, 0}; // neg, zero, pos
            String userInput;

            System.out.print(PROMPT_MESSAGE);

            while (!"X".equals(userInput = scanner.nextLine())) {
                boolean isValidInput = !userInput.isEmpty() && userInput.matches("[0-9\\-\\s]+");
                if (!isValidInput) {
                    System.out.printf(INVALID_MSG, userInput);
                } else {
                    for (String val : userInput.split(" ")) {
                        int value = Integer.parseInt(val);
                        int index = Integer.compare(value, 0) + 1;
                        counts[index] += 1;
                    }
                }
                System.out.print(PROMPT_MESSAGE);
            }
            System.out.printf(RESULT, counts[2], counts[0], counts[1]);
        }
    }
}
