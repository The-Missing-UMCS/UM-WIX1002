package com.umwix1002.solution.lab.Lab4.L4Q4.L4Q4A;

import java.util.Scanner;
public class Main {
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

