package com.umwix1002.solution.viva.viva2526.viva01.set03;

import java.util.Scanner;

public class viva2526v1s3q4 {

    public static void main(String[] args) {
        String input = """
            2
            5 2
            7 1
            """;

        try (Scanner scanner = new Scanner(input)) {
            int numberOfTests = scanner.nextInt();

            for (int t = 0; t < numberOfTests; t++) {
                // 1. Get valid user input (number)
                int n;
                while (true) {
                    n = scanner.nextInt();
                    if (n >= 0 && n <= 20) {
                        break;
                    }
                    System.out.println("Invalid input! Please enter a number between 0 and 20.");
                }

                // 2. Get valid user input (mode)
                int mode;
                while (true) {
                    mode = scanner.nextInt();
                    if (mode >= 1 && mode <= 3) {
                        break;
                    }
                    System.out.println("Invalid input! Please enter a number between 1 and 3.");
                }

                // 3. Calculate factorial
                long factorial = 1;
                for (int i = 1; i <= n; i++) {
                    factorial *= i;
                }

                // 4. Display the result
                System.out.printf("Factorial of %d is %d.%n", n, factorial);

                switch (mode) {
                    case 1 -> System.out.printf("""
                        In Combinatorics Mode: There are %d ways to arrange %d unique items.%n
                        """, factorial, n);
                    case 2 -> System.out.printf("""
                        In Security Mode: You can create %d unique password combinations using %d characters.%n
                        """, factorial, n);
                    case 3 -> System.out.printf("""
                        In Game Mode: You can design %d unique level arrangements from %d elements.%n
                        """, factorial, n);
                    default -> System.out.println("Invalid mode selected!");
                }

                System.out.println(
                    "Tip of the Day: Factorials grow very fast; optimize your code for efficiency!");
            }
        }
    }
}
