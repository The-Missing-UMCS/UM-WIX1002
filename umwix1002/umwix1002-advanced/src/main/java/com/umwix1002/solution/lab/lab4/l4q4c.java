package com.umwix1002.solution.lab.lab4;

import com.umwix1002.solution.lab.constants.CommonConstant;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Ng Zhi Yang
 */
public class l4q4 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the year: ");
            int year = sc.nextInt();
            printCalendar(year, 5);
            System.out.println();
            printCalendar(year, 8);
        }
    }

    /**
     * Displays the calendar for a given year and month.
     * This method uses the java.time API introduced in Java 8 to generate the output.
     * It is intended for learning the Java time API.
     * The output resembles the following:
     *
     * <pre>
     * JULY 2024
     *  MON TUE WED THU FRI SAT SUN
     *        1   2   3   4   5   6
     *    7   8   9  10  11  12  13
     *   14  15  16  17  18  19  20
     *   21  22  23  24  25  26  27
     *   28  29  30  31
     * </pre>
     *
     * @param year  the year to display
     * @param month the month to display
     * @see java.time.DayOfWeek
     */
    private static void printCalendar(int year, int month) {
        if(month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month: " + month);
        }

        // 1. Determine the day of the week for the first day of the given month.
        LocalDate date = LocalDate.of(year, month, 1);
        int firstDayOfMonth = date.getDayOfWeek().getValue() % 7;

        // 2. Print the month name.
        System.out.println(date.getMonth().toString().substring(0, 3) + " " + year);

        // 3. Print the header row showing the days of the week.
        System.out.printf("%4s%4s%4s%4s%4s%4s%4s%n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");

        // 4. Print the initial spaces corresponding to the day of the week of the 1st.
        for (int i = 0; i < firstDayOfMonth; i++) {
            System.out.printf("%4s", "");
        }

        // 5. Print the days of the month, one by one.
        for (int i = 1; i <= 31; i++) {
            System.out.printf("%4s", i);
            boolean isNeedNewLine = (i + firstDayOfMonth) % 7 == 0;
            if (isNeedNewLine) {
                System.out.println();
            }
        }
    }

}
