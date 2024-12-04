package com.umwix1002.solution.lab.lab4;

import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l4q4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the year: ");
            int year = sc.nextInt();
            System.out.print("Enter the first day of the year (0-6): ");
            int firstDayOfYear = sc.nextInt();
            int dayUntilMay = 31 + (isLeapYear(year) ? 29 : 28) + 31 + 30;
            int dayUntilAug = dayUntilMay + 31 + 30 + 31;
            int firstDayOfMay = (firstDayOfYear + dayUntilMay) % 7;
            int firstDayOfAug = (firstDayOfYear + dayUntilAug) % 7;

            System.out.printf("%4s%4s%4s%4s%4s%4s%4s\n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
            for (int i = 0; i < firstDayOfMay; i++) {
                System.out.printf("%4s", "");
            }
            for (int i = 1; i <= 31; i++) {
                System.out.printf("%4s", i);
                if ((i + firstDayOfMay) % 7 == 0) {
                    System.out.println();
                }
            }

            System.out.println();

            System.out.printf("%4s%4s%4s%4s%4s%4s%4s\n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
            for (int i = 0; i < firstDayOfAug; i++) {
                System.out.printf("%4s", "");
            }
            for (int i = 1; i <= 31; i++) {
                System.out.printf("%4s", i);
                if ((i + firstDayOfAug) % 7 == 0) {
                    System.out.println();
                }
            }
        }
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
