package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_1.Q3;

import java.util.Scanner;

public class Main {
    static final int VERTICAL = 1;
    static final int HORIZONTAL = 2;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int fontSize = getIntInput(sc, "Enter font size: ");
            System.out.print("Enter font type: ");
            char fontType = sc.nextLine().charAt(0);
            int format = getIntInput(sc, "Enter format [1 - Vertical, 2 - Horizontal]: ");

            System.out.println(generatePattern(fontSize, String.valueOf(fontType), format));
        }
    }

    static int getIntInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            System.out.print(prompt);
            sc.next();
        }
        int value = sc.nextInt();
        sc.nextLine(); // Consume the newline
        return value;
    }

    public static String generatePattern(int fontSize, String fontType, int format) {
        int horizontalLength = 2 + format / 2 + format * fontSize;

        StringBuilder pattern = new StringBuilder();
        String horizontalLine = fontType.repeat(horizontalLength) + System.lineSeparator();
        pattern.append(horizontalLine);

        int verticalSegments = (format == VERTICAL) ? 2 : 1;

        for (int i = 0; i < verticalSegments; i++) {
            pattern.append(generateVerticalSegment(fontSize, fontType, format));
            pattern.append(horizontalLine);
        }

        return pattern.toString().trim();
    }

    private static String generateVerticalSegment(int fontSize, String fontType, int format) {
        StringBuilder segment = new StringBuilder();

        for (int i = 0; i < fontSize; i++) {
            segment.append(fontType);
            segment.append((" ".repeat(fontSize) + fontType).repeat(format));
            segment.append(System.lineSeparator());
        }

        return segment.toString();
    }
}
