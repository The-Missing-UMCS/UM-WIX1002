package com.umwix1002.solution.viva.viva2526.viva01.set01;

import java.util.Scanner;

public class viva2526v1s1q5a {

    public static void main(String[] args) {
        String input = "4 syukur meriah gembira suka";
        try (Scanner sc = new Scanner(input)) {
            int numOfWords = sc.nextInt();
            for (int i = 0; i < numOfWords; i++) {
                String word = sc.next();
                char lastChar = word.charAt(word.length() - 1);
                if (lastChar == 'a'
                    || lastChar == 'e'
                    || lastChar == 'i'
                    || lastChar == 'o'
                    || lastChar == 'u') {
                    System.out.print("Chaos ");
                    continue;
                }
                boolean isHarmony = true;
                boolean isPreviousVowel = false;
                for (int j = 0; j < word.length(); j++) {
                    char currentChar = word.charAt(j);
                    boolean isCurrentVowel = currentChar == 'a'
                                             || currentChar == 'e'
                                             || currentChar == 'i'
                                             || currentChar == 'o'
                                             || currentChar == 'u';
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
}
