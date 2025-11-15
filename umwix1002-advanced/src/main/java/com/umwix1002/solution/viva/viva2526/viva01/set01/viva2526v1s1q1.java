package com.umwix1002.solution.viva.viva2526.viva01.set01;

import java.util.Scanner;

public class viva2526v1s1q1 {

    public static void main(String[] args) {
        String input = """
            2
            0 2 10
            5 3 5
            """;
        try (Scanner scanner = new Scanner(input)) {
            int numberQueries = scanner.nextInt();
            for (int i = 0; i < numberQueries; i++) {
                int initialValue = scanner.nextInt();
                int multiplierSeed = scanner.nextInt();
                int charmLength = scanner.nextInt();

                for (int j = 0; j < charmLength; j++) {
                    int val = initialValue + multiplierSeed * (int) Math.pow(2, j);
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }
}
