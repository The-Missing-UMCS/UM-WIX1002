package com.umwix1002.solution.lab.lab4;

import com.umwix1002.solution.lab.CommonConstant;

import java.util.Scanner;

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
            displayCalendar(year, firstDayOfYear, 10);
        }
    }

    /**
     * Displays the calendar for a given month.
     *
     * @param year             the year to display
     * @param firstDayOfYear  the first day of the year (0=Sun, 6=Sat)
     * @param month           the month to be displayed (1-12)
     * @throws IllegalArgumentException if the month is out of range or the year is negative
     */
    public static void displayCalendar(int year, int firstDayOfYear, int month) {
        validateYear(year);
        validateMonth(month);
        System.out.println(MONTHS[month - 1]);
        System.out.printf("%4s%4s%4s%4s%4s%4s%4s%n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");

        int firstDayOfMonth = getFirstDayOfMonth(year, firstDayOfYear, month);
        for (int i = CommonConstant.ZERO; i < firstDayOfMonth; i++) {
            System.out.printf("%4s", CommonConstant.BLANK);
        }
        for (int i = CommonConstant.ONE; i <= 31; i++) {
            System.out.printf("%4s", i);
            boolean isNeedNewLine = (i + firstDayOfMonth) % 7 == 0;
            if (isNeedNewLine) {
                System.out.println();
            }
        }
        System.out.println(CommonConstant.LINE_BREAK);
    }

    /**
     * Gets the first day of the month (0=Sun, 6=Sat).
     *
     * @param year            the year
     * @param firstDayOfYear the first day of the year (0-6)
     * @param month          the month (1-12)
     * @return the first day of the month (0-6)
     */
    private static int getFirstDayOfMonth(int year, int firstDayOfYear, int month) {
        int cumulativeDays = 0;

        // Calculate cumulative days from previous months
        // Since the array is 0-based, we need to subtract 1 from the month
        for (int i = CommonConstant.ONE; i < month; i++) {
            cumulativeDays += DAYS_IN_MONTH[i - CommonConstant.ONE];
        }
        int offsetInFeb = month > 2 && isLeapYear(year) ? CommonConstant.ONE : CommonConstant.ZERO;
        return (firstDayOfYear + cumulativeDays + offsetInFeb) % 7;
    }

    /**
     * Determines if a year is a leap year.
     *
     * @param year the year to test
     * @return true if the year is a leap year, false otherwise
     * @throws IllegalArgumentException if the year is negative
     */
    public static boolean isLeapYear(int year) {
        validateYear(year);
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    /**
     * Validates the year.
     *
     * @param year the year to validate
     * @throws IllegalArgumentException if the year is negative
     */
    private static void validateYear(int year) {
        if(year < 0) {
            throw new IllegalArgumentException("Year cannot be negative!");
        }
    }

    /**
     * Validates the month.
     *
     * @param month the month to validate
     * @throws IllegalArgumentException if the month is out of range
     */
    private static void validateMonth(int month) {
        if(month < 1 || month > 12) {
            throw new IllegalArgumentException("Month should be in range [1, 12]");
        }
    }
}