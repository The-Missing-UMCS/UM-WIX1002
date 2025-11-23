package com.umwix1002.solution.viva.viva2526.viva01.set01;

import java.util.Scanner;

public class viva2526v1s1q6b {

    public static void main(String[] args) {
        String input = """
            5 a4b2 log5 4bidden test1ng xy22z
            """;
        try (Scanner scanner = new Scanner(input)) {
            int numOfLogStrings = scanner.nextInt();
            for (int i = 0; i < numOfLogStrings; i++) {
                String compressedLog = scanner.next();
                int length = lengthOfDecompressedLog(compressedLog);
                boolean isValidLog = length != -1;
                System.out.print(isValidLog ? length + " " : "Invalid Log ");
            }
        }
    }

    private static int lengthOfDecompressedLog(String compressedLog) {
        char firstChar = compressedLog.charAt(0);

        if (Character.isDigit(firstChar)) {
            return -1;
        }
        int length = 1;
        char previousChar = firstChar;

        for (int j = 1; j < compressedLog.length(); j++) {
            char currentChar = compressedLog.charAt(j);
            boolean isPrevDigit = Character.isDigit(previousChar);
            boolean isCurDigit = Character.isDigit(currentChar);
            if (isPrevDigit && isCurDigit) {
                return -1;
            } else if (isCurDigit) {
                if (currentChar == '0' || currentChar == '1') {
                    return -1;
                }
                length += currentChar - '0' - 1;
            } else {
                length++;
            }
            previousChar = currentChar;
        }

        return length;
    }
}
