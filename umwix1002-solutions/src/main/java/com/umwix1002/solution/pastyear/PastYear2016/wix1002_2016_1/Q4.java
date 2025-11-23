package com.umwix1002.solution.pastyear.PastYear2016.wix1002_2016_1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) throws Exception {
        final String filePath = "umwix1002-core/src/main/java/com/umwix1002/solution/pastyear/PastYear2016/wix1002_2016_1/Q4.txt";
        try (Scanner sc = new Scanner(new FileInputStream(filePath))) {
            while (sc.hasNextLine()) {
                System.out.println(isStrongPassword(sc.nextLine()) ? "Strong" : "Not a strong password");
            }
        }
    }

    public static boolean isStrongPassword(String password) {
        boolean hasUppercase, hasLowercase, hasDigit, hasSymbol;
        hasUppercase = hasLowercase = hasDigit = hasSymbol = false;

        if (password.length() < 8)
            return false;

        for (char ch : password.toCharArray()) {
            if (!hasUppercase && Character.isUpperCase(ch))
                hasUppercase = true;

            if (!hasLowercase && Character.isLowerCase(ch))
                hasLowercase = true;

            if (!hasDigit && Character.isDigit(ch))
                hasDigit = true;

            if (!hasSymbol && isSymbol(ch))
                hasSymbol = true;

            if (hasUppercase && hasLowercase && hasDigit && hasSymbol)
                return true;
        }

        return false;
    }

    static boolean isSymbol(char ch) {
        return !Character.isLetterOrDigit(ch) && !Character.isWhitespace(ch);
    }
}
