package com.umwix1002.solution.lab.Lab4.L4Q4.L4Q4B;

import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int year = promptWhileInvalid(scanner, "Enter the year: ", y -> y > 0, "Year must be positive");
            int firstDayOfYear = promptWhileInvalid(scanner, "Enter the first day of the year: ", d -> d >= 0 && d <= 6, "First day of year must be between 0 and 6");
            System.out.print("Target month: ");
            int targetMonth = scanner.nextInt();

            Calendar calendar = new Calendar(year, firstDayOfYear);
            if (targetMonth >= 1 && targetMonth <= 12) {
                calendar.printCalendar(targetMonth);
            } else {
                for (int i = 1; i <= 12; i++) {
                    calendar.printCalendar(i);
                }
            }
        }
    }

    private static int promptWhileInvalid(Scanner scanner, String prompt, Predicate<Integer> condition, String errorMessage) {
        int input = -1;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextInt();
            if (condition.test(input)) {
                break;
            }
            System.out.println(errorMessage);
        }
        return input;
    }
}


