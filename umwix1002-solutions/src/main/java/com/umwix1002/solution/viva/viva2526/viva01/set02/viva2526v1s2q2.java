package com.umwix1002.solution.viva.viva2526.viva01.set02;

import java.util.Scanner;

public class viva2526v1s2q2 {

    public static void main(String[] args) {
        String input = """
            2
            15.00 22.00 0 Friday 16 Y
            4 2 -1 0 Saturday 22 N
            """;
        try (Scanner scanner = new Scanner(input)) {
            int testCasesCnt = scanner.nextInt();
            for (int i = 0; i < testCasesCnt; i++) {
                // 1. Getting input
                double subtotal = 0.0;
                double price;
                do {
                    price = scanner.nextDouble();
                    System.out.println("Enter item price (0 to finish): " + price);
                    if (price < 0) {
                        System.out.println(
                            "Invalid amount. Price cannot be negative. Please re-enter.");
                    } else {
                        subtotal += price;
                    }
                } while (price != 0);

                String dayOfWeek;
                while (true) {
                    dayOfWeek = scanner.next();
                    System.out.println("Enter day of week: " + dayOfWeek);
                    if ("Monday".equals(dayOfWeek)
                        || "Tuesday".equals(dayOfWeek)
                        || "Wednesday".equals(dayOfWeek)
                        || "Thursday".equals(dayOfWeek)
                        || "Friday".equals(dayOfWeek)
                        || "Saturday".equals(dayOfWeek)
                        || "Sunday".equals(dayOfWeek)
                    ) {
                        break;
                    }
                    System.out.println(
                        "Invalid dayOfWeek. Please re-enter.");
                }

                int hour;
                while (true) {
                    hour = scanner.nextInt();
                    System.out.println("Enter hour (24-hour format): " + hour);
                    if (hour >= 0 && hour <= 23) {
                        break;
                    }
                    System.out.println("Invalid hour. Please re-enter.");
                }

                String isMemberInput = scanner.next();
                boolean isMember = "Y".equals(isMemberInput);
                System.out.println("Is customer a member (Y/N)? " + isMemberInput);

                // 2. Calculate the value
                double taxRate = subtotal > 100 ? 0.1 : subtotal > 30 ? 0.08 : 0.06;
                double serviceTax = subtotal * taxRate;
                double totalBeforeDiscount = subtotal + serviceTax;

                boolean isWeekday = "Monday".equals(dayOfWeek)
                                    || "Tuesday".equals(dayOfWeek)
                                    || "Wednesday".equals(dayOfWeek)
                                    || "Thursday".equals(dayOfWeek)
                                    || "Friday".equals(dayOfWeek);
                boolean isWeekend = "Saturday".equals(dayOfWeek) || "Sunday".equals(dayOfWeek);

                double totalPayable = totalBeforeDiscount;
                double studentDiscount = 0.0;
                if (isWeekday && totalBeforeDiscount > 25) {
                    studentDiscount = totalBeforeDiscount * 0.10;
                    totalPayable -= studentDiscount;
                }

                double happyHourDiscount = 0.0;
                if (isWeekday && hour >= 15 && hour < 17) {
                    happyHourDiscount = totalPayable * 0.05;
                    totalPayable -= happyHourDiscount;
                }

                double weekendComboDiscount = 0.0;
                if (isWeekend && subtotal >= 50) {
                    weekendComboDiscount = totalBeforeDiscount * 0.05;
                    totalPayable -= weekendComboDiscount;
                }

                double loyaltyCashback = 0.0;
                if (isMember) {
                    loyaltyCashback = totalPayable * 0.02;
                }

                String format = "%-30sRM %.2f%n";
                String separator = "-----------------------------------";
                System.out.println("---- Kopi-Satu Receipt -----------");
                System.out.printf(format, "Subtotal:", subtotal);
                System.out.printf(format, "Service Tax (8%):", serviceTax);
                System.out.printf(format, "Total before discount:", totalBeforeDiscount);
                if (studentDiscount > 0) {
                    System.out.printf(format, "Student Discount (10%):", studentDiscount);
                }
                if (happyHourDiscount > 0) {
                    System.out.printf(format, "Happy Hour Discount (5%):", happyHourDiscount);
                }
                if (weekendComboDiscount > 0) {
                    System.out.printf(format, "Weekend Combo Discount (5%)", weekendComboDiscount);
                }
                System.out.println(separator);
                System.out.printf(format, "Total Payable:", totalPayable);
                System.out.printf(format, "Loyalty Cashback (2%):", loyaltyCashback);
                System.out.println(separator);
                System.out.printf(format, "Final Amount to Collect",
                    totalPayable - loyaltyCashback);
                System.out.println();
            }
        }
    }
}
