package com.umwix1002.solution.viva.viva2526.viva01.set02;

import java.util.Scanner;

public class viva2526v1s2q1 {

    public static void main(String[] args) {
        String input = """
            5
            10 G S 1
            5 M S 0
            65 C S 4
            12 T T 2
            2 G T 0
            """;
        try (Scanner scanner = new Scanner(input)) {
            int numOfTestCases = scanner.nextInt();
            System.out.println(numOfTestCases);
            for (int i = 0; i < numOfTestCases; i++) {
                int daysOverdue = scanner.nextInt();
                String bookTypeCode = scanner.next();
                String borrowerCategory = scanner.next();
                int numberOfPreviousLateReturns = scanner.nextInt();
                System.out.printf("%s %s %s %s%n", daysOverdue, bookTypeCode, borrowerCategory,
                    numberOfPreviousLateReturns);

                double totalFine = 0.0;
                if ("R".equals(bookTypeCode)) {
                    totalFine += 100;
                } else if ("G".equals(bookTypeCode)) {
                    totalFine += Math.min(7, daysOverdue) * 0.5
                                 + Math.max(0, Math.min(30, daysOverdue - 7))
                                 + Math.max(0, daysOverdue - 30) * 2;
                } else if ("M".equals(bookTypeCode)) {
                    totalFine += 0.2 * daysOverdue;
                } else if ("C".equals(bookTypeCode)) {
                    totalFine += Math.min(10, daysOverdue) * 2
                                 + Math.max(0, daysOverdue - 10) * 5;
                } else if ("T".equals(bookTypeCode)) {
                    totalFine += 10 * daysOverdue + ((daysOverdue > 15) ? 200 : 0);
                }

                if (daysOverdue > 60) {
                    totalFine += 25;
                }
                if (numberOfPreviousLateReturns >= 3) {
                    totalFine += 10;
                }

                if ("T".equals(borrowerCategory)) {
                    totalFine *= (1 - 0.2);
                } else if (numberOfPreviousLateReturns == 0 && daysOverdue <= 3) {
                    totalFine *= 0.5;
                }
                System.out.printf("--- Case %d ---%n", i + 1);
                System.out.printf("Total Fine: RM % .2f%n%n", totalFine);
            }
        }
    }
}
