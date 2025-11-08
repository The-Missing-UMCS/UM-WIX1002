package com.umwix1002.solution.lab.lab04;

import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l4q4a {

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

            String columnFormat = "%4s";
            String format = "%4s%4s%4s%4s%4s%4s%4s%n";

            // 3. Print the calendar of May
            System.out.printf(format, "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
            for (int i = 0; i < firstDayOfMay; i++) {
                System.out.printf(columnFormat, "");
            }
            for (int i = 1; i <= 31; i++) {
                System.out.printf(columnFormat, i);
                if ((i + firstDayOfMay) % 7 == 0) {
                    System.out.println();
                }
            }

            System.out.println();

            // 4. Print the calendar of August
            System.out.printf(format, "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
            for (int i = 0; i < firstDayOfAug; i++) {
                System.out.printf(columnFormat, "");
            }
            for (int i = 1; i <= 31; i++) {
                System.out.printf(columnFormat, i);
                if ((i + firstDayOfAug) % 7 == 0) {
                    System.out.println();
                }
            }
        }
    }
}
