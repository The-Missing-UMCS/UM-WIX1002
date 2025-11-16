package com.umwix1002.solution.viva.viva2526.viva01.set03;

import java.util.Scanner;

public class viva2526v1s3q2a {

    public static void main(String[] args) {
        String input = """
            residential 3000
            commercial 15000
            residential 0
            """;

        try (Scanner scanner = new Scanner(input)) {
            while (true) {
                // 1. Get the user input
                String customerType = scanner.next();
                int liters = scanner.nextInt();

                // Exit condition
                if (liters == 0) {
                    break;
                }

                // Validate customer type
                boolean isResidential = "residential".equalsIgnoreCase(customerType);
                boolean isCommercial = "commercial".equalsIgnoreCase(customerType);

                if (!isResidential && !isCommercial) {
                    System.out.println("Error: Invalid customer type!");
                    System.out.println();
                    continue;
                }

                if (liters < 0 || liters > 50000) {
                    System.out.println("Error: Invalid liters entered!");
                    System.out.println();
                    continue;
                }

                double totalBill;

                if (isResidential) {
                    if (liters <= 1000) {
                        totalBill = liters * 0.02;
                    } else if (liters <= 5000) {
                        totalBill = liters * 0.05;
                    } else {
                        totalBill = liters * 0.08;
                    }
                } else { // commercial
                    if (liters <= 10000) {
                        totalBill = liters * 0.06;
                    } else {
                        totalBill = liters * 0.10;
                    }
                }

                String formattedCustomerType = Character.toUpperCase(customerType.charAt(0))
                                               + customerType.substring(1);
                System.out.printf(
                    """
                        Customer Type: %s
                        Water Usage: %d L
                        Total Bill: RM%.2f
                        Thank you for conserving water!
                        %n""", formattedCustomerType, liters, totalBill);
            }
        }
    }
}

