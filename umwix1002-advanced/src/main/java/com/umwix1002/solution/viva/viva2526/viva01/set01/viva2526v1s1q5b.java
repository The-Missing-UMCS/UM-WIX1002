package com.umwix1002.solution.viva.viva2526.viva01.set01;

import java.util.Scanner;

public class viva2526v1s1q5b {

    public static void main(String[] args) {
        String input = "4 syukur meriah gembira suka";
        try (Scanner sc = new Scanner(input)) {
            int numOfWords = sc.nextInt();
            for (int i = 0; i < numOfWords; i++) {
                String word = sc.next();
                char lastChar = word.charAt(word.length() - 1);
                if (isVowel(lastChar)) {
                    System.out.print("Chaos ");
                    continue;
                }
                boolean isHarmony = true;
                boolean isPreviousVowel = false;
                for (char currentChar : word.toCharArray()) {
                    boolean isCurrentVowel = isVowel(currentChar);
                    if (isPreviousVowel && isCurrentVowel) {
                        isHarmony = false;
                        break;
                    }
                    isPreviousVowel = isCurrentVowel;
                }
                System.out.print(isHarmony ? "Harmony " : "Chaos ");
            }
        }
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
