package com.umwix1002.solution.lab.Lab4.L4Q4.L4Q4B;

import lombok.RequiredArgsConstructor;

import java.time.Month;
import java.util.Arrays;

@RequiredArgsConstructor
public class Calendar {
    private static final String[] MONTHS = Arrays.stream(Month.values())
        .map(month -> month.name().toUpperCase().substring(0, 3))
        .toArray(String[]::new);

    private static final String[] DAY_OF_WEEK = {"SUN", "MON", "TUE", "WED", "THUR", "FRI", "SAT"};
    private static final int[] DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private final int year;
    private final int firstDayOfYear;

    private boolean isLeapYear(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    public void printCalendar(int month) {
        System.out.println("\nMONTH: " + MONTHS[month - 1]);
        String[] label = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};

        for (int i = 0; i < 7; i++) {
            System.out.printf("%8s", label[i]);
        }
        System.out.println();

        int[] weeks = getCalendar(month);
        for (int week = 0; week < 6; week++) {
            for (int dayOfWeek = 0; dayOfWeek < 7; dayOfWeek++) {
                boolean hasNoValue = weeks[week * 7 + dayOfWeek] == 0;
                System.out.printf("%8s", hasNoValue ? "" : weeks[week * 7 + dayOfWeek]);
            }
            System.out.println();
        }
    }

    private int[] getCalendar(int month) {
        int[] weeks = new int[42];
        int firstDayOfMonth = getFirstDayOfMonth(month);
        for (int i = 0; i < DAYS[month]; i++) {
            weeks[i + firstDayOfMonth] = i + 1;
        }
        return weeks;
    }

    private int getFirstDayOfMonth(int month) {
        int cumalativeDays = 0;

        for (int i = 1; i < month; i++) {
            cumalativeDays += (i == 2 && isLeapYear(year)) ? 29 : DAYS[i];
        }

        return (firstDayOfYear + (cumalativeDays)) % 7;
    }
}
