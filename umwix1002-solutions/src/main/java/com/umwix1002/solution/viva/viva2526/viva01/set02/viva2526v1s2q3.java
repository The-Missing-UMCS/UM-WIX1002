package com.umwix1002.solution.viva.viva2526.viva01.set02;

import java.util.Scanner;

public class viva2526v1s2q3 {

    public static void main(String[] args) {
        String input = """
            2
            alice aLicE2024!
            bob password
            """;
        try (Scanner scanner = new Scanner(input)) {
            int testCases = scanner.nextInt();
            for (int i = 0; i < testCases; i++) {
                String username = scanner.next();
                System.out.println("Enter username: " + username);

                String password = scanner.next();
                System.out.println("Enter password: " + password);

                // 1. Check if username is valid
                boolean isUsernameValid = true;
                // Rule 1: Must start with a letter (A–Z or a–z).
                if ((username.charAt(0) < 'a' || username.charAt(0) > 'z')
                    && (username.charAt(0) < 'A' || username.charAt(0) > 'Z')) {
                    isUsernameValid = false;
                }
                // Rule 2: Must be 5–15 characters long.
                if (username.length() < 5 || username.length() > 15) {
                    isUsernameValid = false;
                }
                // Rule 3 & 4: Can contain letters, digits, or underscores only.
                for (int j = 0; j < username.length(); j++) {
                    char ch = username.charAt(j);
                    boolean isLowercase = ch >= 'a' && ch <= 'z';
                    boolean isDigit = ch >= '0' && ch <= '9';
                    boolean isUnderscore = ch == '_';
                    if (!(isLowercase || isDigit || isUnderscore)) {
                        isUsernameValid = false;
                        break;
                    }
                }

                if (!isUsernameValid) {
                    System.out.println("Invalid username");
                    continue;
                }

                // 2. Measure password strength
                int rulesMet = 0;
                if (password.length() >= 8) {
                    rulesMet++;
                }

                boolean hasUppercaseLetter = false;
                boolean hasLowercaseLetter = false;
                boolean hasDigit = false;
                boolean hasSpecialCharacter = false;
                boolean hasNoSpaces = true;
                for (int j = 0; j < password.length(); j++) {
                    char ch = password.charAt(j);
                    if (ch >= 'A' && ch <= 'Z') {
                        hasUppercaseLetter = true;
                    } else if (ch >= 'a' && ch <= 'z') {
                        hasLowercaseLetter = true;
                    } else if (ch >= '0' && ch <= '9') {
                        hasDigit = true;
                    } else if (ch == '!'
                               || ch == '@'
                               || ch == '#'
                               || ch == '$'
                               || ch == '%'
                               || ch == '^'
                               || ch == '&'
                               || ch == '*') {
                        hasSpecialCharacter = true;
                    } else if (ch == ' ') {
                        hasNoSpaces = false;
                    }
                }

                rulesMet += (hasUppercaseLetter ? 1 : 0)
                            + (hasLowercaseLetter ? 1 : 0)
                            + (hasDigit ? 1 : 0)
                            + (hasSpecialCharacter ? 1 : 0)
                            + (hasNoSpaces ? 1 : 0);

                boolean found;
                for (int j = 0; j < password.length() - username.length(); j++) {
                    found = true;
                    for (int k = 0; k < username.length(); k++) {
                        if (password.charAt(j + k) != username.charAt(k)) {
                            found = false;
                            break;
                        }
                    }
                    if (found) {
                        rulesMet++;
                        break;
                    }
                }

                String rating;
                if (rulesMet == 7) {
                    rating = "Very Strong";
                } else if (rulesMet == 6) {
                    rating = "Strong";
                } else if (rulesMet >= 4) {
                    rating = "Moderate";
                } else {
                    rating = "Weak";
                }

                System.out.println("Password Strength: " + rating);
                System.out.println();
            }
        }
    }
}
