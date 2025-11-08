package com.umwix1002.solution.lab.lab04;

import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l4q4c {

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
            int firstDayOfMay = calculateFirstDayOfMonth(firstDayOfYear, 5, year);
            int firstDayOfAug = calculateFirstDayOfMonth(firstDayOfYear, 8, year);

            // 3. Print the calendar of May
            printCalendar(firstDayOfMay, 5, year);

            System.out.println(System.lineSeparator());

            // 4. Print the calendar of August
            printCalendar(firstDayOfAug, 8, year);
        }
    }

    private static int calculateFirstDayOfMonth(int firstDayOfYear, int month, int year) {
        /*
         * 1. Set up the monthDays that stores the number of days in each month.
         *    For example,
         *      - monthDays[0] = 31 → January has 31 days
         *      - monthDays[1] = 28 → February has 28 days
         *
         *    If the given year is a leap year, we should update monthDays[1] (February) to 29 days.
         */
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        monthDays[1] = isLeapYear ? 29 : 28;

        // 2. Calculate the total number of days from the beginning of the year up to the target month.
        int daysUntilMonth = 0;
        for (int i = 0; i < month - 1; i++) {
            daysUntilMonth += monthDays[i];
        }

        /*
         * 3. Compute the day of the week for the first day of the given month.
         *    The day index is defined as follows:
         *      0 → Sunday
         *      1 → Monday
         *      2 → Tuesday
         *      3 → Wednesday
         *      4 → Thursday
         *      5 → Friday
         *      6 → Saturday
         */
        return (firstDayOfYear + daysUntilMonth) % 7;
    }

    private static void printCalendar(int firstDayOfMonth, int month, int year) {
        String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT",
            "NOV", "DEC"};

        System.out.println(months[month - 1] + " " + year);
        System.out.printf(FORMAT, "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
        for (int i = 0; i < firstDayOfMonth; i++) {
            System.out.printf(COLUMN_FORMAT, "");
        }
        for (int i = 1; i <= 31; i++) {
            System.out.printf(COLUMN_FORMAT, i);
            boolean needNewLine = (i + firstDayOfMonth) % 7 == 0;
            if (needNewLine) {
                System.out.println();
            }
        }
    }
}
