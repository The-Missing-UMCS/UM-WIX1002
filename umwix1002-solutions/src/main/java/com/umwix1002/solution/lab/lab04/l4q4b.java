package com.umwix1002.solution.lab.lab04;

import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l4q4b {

    private static final String COLUMN_FORMAT = "%4s";
    private static final String FORMAT = "%4s%4s%4s%4s%4s%4s%4s%n";

    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            // 1. Get the input from users
            System.out.print("Enter the year: ");
            int year = sc.nextInt();
            System.out.print("Enter the first day of the year (0-6): ");
            int firstDayOfYear = sc.nextInt();

            // 2. Perform required calculation
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            int dayUntilMay = 31 + (isLeapYear ? 29 : 28) + 31 + 30;
            int dayUntilAug = dayUntilMay + 31 + 30 + 31;
            int firstDayOfMay = (firstDayOfYear + dayUntilMay) % 7;
            int firstDayOfAug = (firstDayOfYear + dayUntilAug) % 7;

            // 3. Print the calendar of May
            printCalendar(firstDayOfMay);

            System.out.println();

            // 4. Print the calendar of August
            printCalendar(firstDayOfAug);
        }
    }

    private static void printCalendar(int firstDayOfMonth) {
        System.out.printf(FORMAT, "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
        for (int i = 0; i < firstDayOfMonth; i++) {
            System.out.printf(COLUMN_FORMAT, "");
        }
        for (int i = 1; i <= 31; i++) {
            System.out.printf(COLUMN_FORMAT, i);
            if ((i + firstDayOfMonth) % 7 == 0) {
                System.out.println();
            }
        }
    }
}
