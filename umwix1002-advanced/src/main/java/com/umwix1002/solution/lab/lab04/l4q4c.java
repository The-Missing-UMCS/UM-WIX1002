package com.umwix1002.solution.lab.lab04;

import org.apache.commons.lang3.Validate;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l4q4c {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the year: ");
            int year = sc.nextInt();
            printCalendar(year, 5);
            System.out.println();
            printCalendar(year, 8);
        }
    }

    private static void printCalendar(int year, int month) {
        Validate.isTrue(year >= 0, "Invalid year: " + year);
        Validate.isTrue(month >= 1 && month <= 12, "Invalid month: " + month);

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
