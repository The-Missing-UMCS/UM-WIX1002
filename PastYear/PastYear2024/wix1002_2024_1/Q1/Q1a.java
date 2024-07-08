package wix1002_2024_1.Q1;

import java.util.Scanner;

public class Q1a {
    public static void main(String[] args) {
        int[] counts = countNumbers();
        System.out.printf("Positive: %d, Negative: %d, Zeros: %d", counts[2], counts[0], counts[1]);
    }

    public static int[] countNumbers() {
        int[] counts = new int[] { 0, 0, 0 }; // neg, zero, pos
        Scanner scanner = new Scanner(System.in);
        String userInput;
        final String PROMPT_MESSAGE = "Int value(s) (X to quit): ";
        System.out.print(PROMPT_MESSAGE);
        while (!"X".equals(userInput = scanner.nextLine())) {
            boolean isValidInput = !userInput.isEmpty() &&
                    userInput.matches("[0-9\\-\s]+");
            if (isValidInput)
                for (String val : userInput.split(" "))
                    // Integer.compare returns -1, 0, or 1.
                    // Adding 1 when indexing makes it to 0, 1, or 2.
                    // Prefer Integer.compare over if-else.
                    counts[Integer.compare(Integer.parseInt(val), 0) + 1] += 1;
            else
                System.out.printf("Invalid value {%s}. Please enter an integer value.\n", userInput);
            System.out.print(PROMPT_MESSAGE);
        }
        scanner.close();
        return counts;
    }
}
