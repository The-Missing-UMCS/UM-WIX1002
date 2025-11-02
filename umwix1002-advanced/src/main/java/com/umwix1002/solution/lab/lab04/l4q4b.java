package com.umwix1002.solution.lab.lab04;

import org.apache.commons.lang3.Validate;

import java.util.Scanner;

import static com.umwix1002.solution.lab.constants.CommonConstant.*;

/**
 * @author Ng Zhi Yang
 */
public class l4q4b {
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] MONTHS = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the year: ");
            int year = scanner.nextInt();
            System.out.print("Enter the first day of the year (0-6): ");
            int firstDayOfYear = scanner.nextInt();

            final int MAY = 5, AUGUST = 8;
            displayCalendar(year, firstDayOfYear, MAY);
            displayCalendar(year, firstDayOfYear, AUGUST);
        }
    }

    public static void displayCalendar(int year, int firstDayOfYear, int month) {
        Validate.isTrue(year >= 0, "Invalid year: " + year);
        Validate.isTrue(month >= 1 && month <= 12, "Invalid month: " + month);
        System.out.println(MONTHS[month - 1]);
        System.out.printf("%4s%4s%4s%4s%4s%4s%4s%n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");

        int firstDayOfMonth = getFirstDayOfMonth(year, firstDayOfYear, month);
        for (int i = ZERO; i < firstDayOfMonth; i++) {
            System.out.printf("%4s", BLANK);
        }
        for (int i = ONE; i <= 31; i++) {
            System.out.printf("%4s", i);
            boolean isNeedNewLine = (i + firstDayOfMonth) % 7 == 0;
            if (isNeedNewLine) {
                System.out.println();
            }
        }
        System.out.println(LINE_BREAK);
    }

    private static int getFirstDayOfMonth(int year, int firstDayOfYear, int month) {
        int cumulativeDays = 0;

        // Calculate cumulative days from previous months
        // Since the array is 0-based, we need to subtract 1 from the month
        for (int i = ONE; i < month; i++) {
            cumulativeDays += DAYS_IN_MONTH[i - ONE];
        }
        int offsetInFeb = month > 2 && isLeapYear(year) ? ONE : ZERO;
        return (firstDayOfYear + cumulativeDays + offsetInFeb) % 7;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}