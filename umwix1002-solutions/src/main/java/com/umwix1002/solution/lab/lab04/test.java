package com.umwix1002.solution.lab.lab04;

import java.util.Scanner;

public class test {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int year = 0, d1 = 0;

        System.out.print("Enter year and first day of the year (separated by 1 white space): ");
        year = sc.nextInt();
        d1 = sc.nextInt();

        int daystoMay = 31 + (isLeap(year) ? 29 : 28) + 31 + 30;
        int daystoAug = daystoMay + 31 + 30 + 31;

        displayCalendar((d1 + daystoMay) % 7, year, "May", 31);
        displayCalendar((d1 + daystoAug) % 7, year, "August", 31);

        sc.close();
    }

    static boolean isLeap(int year) {
        return (year % 400 == 0) || (year % 100 != 0) && (year % 4 == 0);
    }

    static void displayCalendar(int dayinWeek, int year, String month, int daysinMonth) {

        System.out.printf("\nCalendar for %s %d\n", month, year);
        System.out.println("┌─────┬─────┬─────┬─────┬─────┬─────┬─────┐");
        System.out.println("│ Sun │ Mon │ Tue │ Wed │ Thu │ Fri │ Sat |");
        System.out.println("├─────┼─────┼─────┼─────┼─────┼─────┼─────┤");
        System.out.print(("│     ").repeat(dayinWeek));

        for (int i = 1; i <= daysinMonth; i++) {

            System.out.printf("│ %s  ", (i < 10) ? "0" + i : i);
            dayinWeek++;

            if (dayinWeek % 7 == 0) {
                System.out.print("│\n├─────┼─────┼─────┼─────┼─────┼─────┼─────┤\n");
                dayinWeek = 0;
            }
        }

        System.out.print(
            ("│     ").repeat(7 - dayinWeek) + "│\n└─────┴─────┴─────┴─────┴─────┴─────┴─────┘\n");
    }

}
