package com.umwix1002.solution.viva.viva2526.viva01.set02;

import java.util.Scanner;

public class viva2526v1s2q5 {

    public static void main(String[] args) {
        String input = """
            1
            hello world
            """;
        try (Scanner scanner = new Scanner(input)) {
            int testCases = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < testCases; i++) {
                String message = scanner.nextLine();
                System.out.println("Enter Original Message: " + message);
                System.out.println("Encoded Message:");
                for (int j = 0; j < message.length(); j++) {
                    // 1. Get ASCII decimal value
                    int ascii = message.charAt(j);

                    // 2. Convert to 8-bit binary
                    int[] bits = new int[8];
                    int value = ascii;

                    for (int b = 7; b >= 0; b--) {
                        bits[b] = value % 2;
                        value /= 2;
                    }

                    // 3. Invert bits
                    for (int b = 0; b < 8; b++) {
                        bits[b] = (bits[b] == 0 ? 1 : 0);
                    }

                    // 4. Convert inverted binary back to decimal
                    int encodedValue = 0;
                    int power = 1;

                    for (int b = 7; b >= 0; b--) {
                        encodedValue += bits[b] * power;
                        power *= 2;
                    }

                    System.out.print(encodedValue);

                    if (j < message.length() - 1) {
                        System.out.print(" ");
                    }
                }
            }
        }
    }
}
