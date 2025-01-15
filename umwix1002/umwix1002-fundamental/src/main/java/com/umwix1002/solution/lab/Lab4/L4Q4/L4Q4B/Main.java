package com.umwix1002.solution.lab.Lab4.L4Q4.L4Q4B;

import org.apache.commons.lang3.Validate;

import java.util.*;

public class L4Q4B {
    public static void main(String[] args) {
        while (true) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Enter the year: ");
                int year = scanner.nextInt();
                Validate.isTrue(year > 0, "Year must be positive");

                System.out.print("Enter the first day of the year: ");
                int firstDayOfYear = scanner.nextInt();
                Validate.isTrue(firstDayOfYear >= 0 && firstDayOfYear <= 6, "First day of year must be between 0 and 6");

                System.out.print("Target month: ");
                int targetMonth = scanner.nextInt();

                Calendar calendar = new Calendar(year, firstDayOfYear);
                if (targetMonth >= 1 && targetMonth <= 12) {
                    calendar.printCalendar(targetMonth);
                } else {
                    for (int i = 1; i <= 12; i++) {
                        calendar.printCalendar(i);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}


