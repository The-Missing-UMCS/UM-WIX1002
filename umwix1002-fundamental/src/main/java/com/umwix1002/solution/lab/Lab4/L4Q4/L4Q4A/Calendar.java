package com.umwix1002.solution.lab.Lab4.L4Q4.L4Q4A;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Calendar {
    private static final int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] monthName = {"", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
    private final int year;
    private final int firstDayOfYear;

    public void displayCalendar(int month) {
        System.out.println(monthName[month]);
        System.out.printf("%4s%4s%4s%4s%4s%4s%4s\n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
        int firstDayOfMonth = getFirstDayOfMonth(month);
        for (int i = 0; i < firstDayOfMonth; i++)
            System.out.printf("%4s", "");
        for (int i = 1; i <= 31; i++) {
            System.out.printf("%4s", i);
            if ((i + firstDayOfMonth) % 7 == 0)
                System.out.println("");
        }
        System.out.println("\n");
    }

    private boolean isLeapYear() {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    private int getFirstDayOfMonth(int month) {
        int days = 0;
        for (int i = 1; i < month; i++)
            days += daysInMonth[i];
        return (firstDayOfYear + days + (isLeapYear() ? 1 : 0)) % 7;
    }
}
