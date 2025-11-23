package com.umwix1002.solution.viva.viva2526.viva01.set02;

import java.util.Scanner;

public class viva2526v1s2q4 {

    public static void main(String[] args) {
        String input = """
            2
            010203-04-0506
            030831-12-0136
            """;

        try (Scanner scanner = new Scanner(input)) {
            int testCases = scanner.nextInt();
            for (int t = 0; t < testCases; t++) {
                String ic = scanner.next();
                // Keep only digits from the IC
                StringBuilder digitsBuilder = new StringBuilder();
                for (int i = 0; i < ic.length(); i++) {
                    char ch = ic.charAt(i);
                    if (ch >= '0' && ch <= '9') {
                        digitsBuilder.append(ch);
                    }
                }
                String digits = digitsBuilder.toString();

                int yearTwoDigits = (digits.charAt(0) - '0') * 10 + (digits.charAt(1) - '0');
                int month = (digits.charAt(2) - '0') * 10 + (digits.charAt(3) - '0');
                int day = (digits.charAt(4) - '0') * 10 + (digits.charAt(5) - '0');

                int fullYear;
                if (yearTwoDigits <= 25) {
                    fullYear = 2000 + yearTwoDigits;
                } else {
                    fullYear = 1900 + yearTwoDigits;
                }

                // Sum of all digits
                int sumOfDigits = 0;
                for (int i = 0; i < digits.length(); i++) {
                    sumOfDigits += digits.charAt(i) - '0';
                }

                // Gender from last digit
                int lastDigit = digits.charAt(digits.length() - 1) - '0';
                boolean isMale = (lastDigit % 2 == 1);
                String gender = isMale ? "Male" : "Female";

                // Month type: long or short
                boolean isLongMonth = isLongMonth(month);

                // Lucky winner rules
                boolean isLucky;
                if (isMale) {
                    boolean isShortMonth = !isLongMonth;
                    isLucky = (sumOfDigits % 5 == 0) && isShortMonth;
                } else {
                    isLucky = (sumOfDigits % 7 == 0) && isLongMonth;
                }

                // Output
                System.out.println("Birth Date: " + day + "/" + month + "/" + fullYear);
                System.out.println("Gender: " + gender);
                System.out.println("Sum of Digits: " + sumOfDigits);
                System.out.println("Lucky Winner: " + (isLucky ? "Yes" : "No"));
                System.out.println();
            }
        }
    }

    private static boolean isLongMonth(int month) {
        return month == 1 || month == 3 || month == 5 ||
               month == 7 || month == 8 || month == 10 || month == 12;
    }
}
