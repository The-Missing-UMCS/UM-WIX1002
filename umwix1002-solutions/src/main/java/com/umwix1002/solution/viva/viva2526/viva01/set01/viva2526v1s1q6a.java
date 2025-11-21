package com.umwix1002.solution.viva.viva2526.viva01.set01;

import java.util.Scanner;

public class viva2526v1s1q6a {

    public static void main(String[] args) {
        String input = """
            5 a4b2 log5 4bidden test1ng xy22z
            """;
        try (Scanner scanner = new Scanner(input)) {
            int numOfLogStrings = scanner.nextInt();

            for (int i = 0; i < numOfLogStrings; i++) {
                String compressedLog = scanner.next();

                // Rule A: The very first character of the compressed string is a digit
                if (compressedLog.charAt(0) >= '0' && compressedLog.charAt(0) <= '9') {
                    System.out.print("Invalid Log ");
                    continue;
                }

                int lengthOfDecompressedLog = 1;
                char previousChar = compressedLog.charAt(0);
                boolean isValidLog = true;
                for (int j = 1; j < compressedLog.length(); j++) {
                    char currentChar = compressedLog.charAt(j);
                    boolean isPreviousCharDigit = previousChar >= '0' && previousChar <= '9';
                    boolean isCurrentCharDigit = currentChar >= '0' && currentChar <= '9';
                    boolean isPreviousCharCharacter = !isPreviousCharDigit;
                    boolean isCurrentCharCharacter = !isCurrentCharDigit;

                    // Rule B: A digit is preceded by another digit.
                    if (isPreviousCharDigit && isCurrentCharDigit) {
                        isValidLog = false;
                        break;
                    } else if (isPreviousCharDigit && isCurrentCharCharacter) {
                        lengthOfDecompressedLog++;
                    } else if (isPreviousCharCharacter && isCurrentCharDigit) {
                        // Rule C: The log contains the digits '0' or '1', as they are not used in this compression scheme.
                        if (currentChar == '0' || currentChar == '1') {
                            isValidLog = false;
                            break;
                        } else {
                            lengthOfDecompressedLog += currentChar - '0' - 1;
                        }
                    } else {
                        lengthOfDecompressedLog++;
                    }
                    previousChar = currentChar;
                }
                System.out.print(isValidLog ? lengthOfDecompressedLog + " " : "Invalid Log ");
            }
        }
    }
}
