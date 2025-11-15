package com.umwix1002.solution.viva.viva2526.viva01.set01;

import java.util.Scanner;

public class viva2526v1s1q3 {

    public static void main(String[] args) {
        String input = """
            3
            4 P
            5 A
            3 P
            """;
        try (Scanner scanner = new Scanner(input)) {
            int numberOfQueries = scanner.nextInt();
            for (int i = 0; i < numberOfQueries; i++) {
                int height = scanner.nextInt();
                String style = scanner.next();

                if ("P".equals(style)) {
                    for (int row = 1; row <= height; row++) {
                        // Print the blank
                        for (int j = 0; j < height - row; j++) {
                            System.out.print(" ");
                        }
                        // Print the left hand side
                        for (int col = 1; col < row; col++) {
                            System.out.print(col);
                        }

                        // Print the middle value
                        System.out.print(row);

                        // Print the right hand side
                        for (int col = row - 1; col > 0; col--) {
                            System.out.print(col);
                        }

                        // Print new line
                        System.out.println();
                    }
                } else if ("A".equals(style)) {
                    for (int row = 1; row <= height; row++) {
                        // Print repeated character
                        for (int j = 0; j < row; j++) {
                            System.out.print(row);
                        }

                        // Print new line
                        System.out.println();

                        // Or
                        // System.out.println(String.valueOf(row).repeat(row));
                    }
                }
            }
        }
    }
}
