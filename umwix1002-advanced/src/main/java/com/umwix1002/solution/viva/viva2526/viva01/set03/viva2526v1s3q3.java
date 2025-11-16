package com.umwix1002.solution.viva.viva2526.viva01.set03;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class viva2526v1s3q3 {

    public static void main(String[] args) {
        String input = """
            1011
            1100
            1110
            STOP
            """;

        try (Scanner scanner = new Scanner(input)) {
            List<String> binaryCodes = new ArrayList<>();

            // 1. Get user's input.
            String userInput;
            while (true) {
                userInput = scanner.next();
                if ("STOP".equals(userInput)) {
                    break;
                }
                boolean isValidBinary = userInput.matches("^[01]+$");
                /*
                boolean isValidBinary = true;
                for (char ch : userInput.toCharArray()) {
                    if (ch != '0' || ch != '1') {
                        isValidBinary = false;
                        break;
                    }
                }
                 */
                if (!isValidBinary) {
                    System.out.println("Invalid code: must contain only 0s and 1s");
                }
                binaryCodes.add(userInput);
            }

            // 2. Convert into decimal and calculate
            DescriptiveStatistics captainAmericaStats = new DescriptiveStatistics();
            DescriptiveStatistics ironManStats = new DescriptiveStatistics();
            /*
            int captainAmericaCount = 0;
            int captainAmericaSum = 0;
            int ironManCount = 0;
            int ironManSum = 0;
             */
            for (String binaryCode : binaryCodes) {
                int decimal = Integer.parseInt(binaryCode, 2);
                String team = (decimal & 1) == 1 ? "Captain America" : "Iron Man";
                if ("Captain America".equals(team)) {
                    captainAmericaStats.addValue(decimal);
                } else {
                    ironManStats.addValue(decimal);
                }
                System.out.printf("Code %s -> Decimal %d -> %s's Team%n",
                    binaryCode, decimal, team);
            }

            System.out.printf("""
                    
                    Iron Man Team: %d code%s | Average Power: %.0f
                    Captain America Team: %d code%s | Average Power: %.0f
                    Mission Accomplished: Message Decrypted!
                    """,
                ironManStats.getN(), ironManStats.getN() > 1 ? "s" : "", ironManStats.getMean(),
                captainAmericaStats.getN(), captainAmericaStats.getN() > 1 ? "s" : "",
                captainAmericaStats.getMean()
            );
        }
    }
}
