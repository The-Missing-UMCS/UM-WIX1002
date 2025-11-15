package com.umwix1002.solution.viva.viva2526.viva01.set01;

import java.util.Scanner;

public class viva2526v1s1q2 {

    public static void main(String[] args) {
        String input = """
            4
            881307 8
            2213 5
            1110 1
            8888 8
            """;
        try (Scanner scanner = new Scanner(input)) {
            int numberOfQueries = scanner.nextInt();

            for (int i = 0; i < numberOfQueries; i++) {
                int number = scanner.nextInt();
                int luckyDigit = scanner.nextInt();

                int countOfLuckyDigit = 0;
                int countOfEvenDigit = 0;
                int countOfOddDigit = 0;
                int countOfZeroCount = 0;

                // Iterate through all digits in the given number.
                for (; number > 0; number /= 10) {
                    int digit = number % 10;
                    if (digit == luckyDigit) {
                        countOfLuckyDigit++;
                    } else if (digit == 0) {
                        countOfZeroCount++;
                    } else if (digit % 2 == 0) {
                        countOfEvenDigit++;
                    } else {
                        countOfOddDigit++;
                    }
                }

                // Decide what to print
                if (countOfLuckyDigit > countOfEvenDigit
                    && countOfLuckyDigit > countOfOddDigit
                    && countOfLuckyDigit > countOfZeroCount) {
                    System.out.println("LUCKY");
                } else if (countOfEvenDigit > countOfLuckyDigit
                           && countOfEvenDigit > countOfOddDigit
                           && countOfEvenDigit > countOfZeroCount) {
                    System.out.println("BALANCED");
                } else if (countOfOddDigit > countOfLuckyDigit
                           && countOfOddDigit > countOfEvenDigit
                           && countOfOddDigit > countOfZeroCount) {
                    System.out.println("ENERGETIC");
                } else {
                    System.out.println("NEUTRAL");
                }
            }
        }
    }
}
