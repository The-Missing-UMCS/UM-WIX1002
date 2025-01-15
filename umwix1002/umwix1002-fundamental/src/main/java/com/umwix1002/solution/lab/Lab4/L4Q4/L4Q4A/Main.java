package com.umwix1002.solution.lab.Lab4.L4Q4;

import java.util.Scanner;
public class L4Q4A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = sc.nextInt();
        System.out.print("Enter the first day of the year (0-6): ");
        int firstDayOfYear = sc.nextInt(); sc.close();
        Calendar cal = new Calendar(year, firstDayOfYear);
        cal.displayCalendar(5);
        cal.displayCalendar(8);
        cal.displayCalendar(12);
    }
}

class Calendar {
    private static int[] daysInMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    private static String[] monthName = {"", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT","NOV","DEC"};
    int year;
    int firstDayOfYear;

    Calendar(int year, int firstDayOfYear) {
        this.year = year;
        this.firstDayOfYear = firstDayOfYear;
    }

    int getFirstDayOfMonth(int month) {
        int days = 0;
        for(int i = 1; i < month; i++) 
            days += daysInMonth[i];
        return (firstDayOfYear + days + (isLeapYear() ? 1 : 0)) % 7;
    }

    void displayCalendar(int month) {
        System.out.println(monthName[month]);
        System.out.printf("%4s%4s%4s%4s%4s%4s%4s\n", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat");
        int firstDayOfMonth = getFirstDayOfMonth(month);
        for(int i = 0; i < firstDayOfMonth; i++) 
            System.out.printf("%4s", "");
        for (int i = 1; i <= 31; i++) {
            System.out.printf("%4s", i);
            if ((i + firstDayOfMonth) % 7 == 0) 
                System.out.println("");
        }
        System.out.println("\n");
    }

    boolean isLeapYear() {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}

