package com.umwix1002.solution.pastyear.PastYear2017.wix1002_2017_1.Q3;

import java.util.Random;

public class Q3 {
    private static final int ASCENDING = 1;
    private static final int DESCENDING = -1;
    private static final int STRING_LENGTH = 6;

    public static void main(String[] args) {
        char[] string = generateRandomString(STRING_LENGTH);
        System.out.println("The string generated is " + new String(string));

        sortCharacters(string, ASCENDING);
        System.out.println("String sorted in ascending order: " + new String(string));

        sortCharacters(string, DESCENDING);
        System.out.println("String sorted in descending order: " + new String(string));
    }

    public static char[] generateRandomString(int length) {
        char[] string = new char[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int rand = random.nextBoolean() ? random.nextInt(65, 91) : random.nextInt(97, 123);
            string[i] = (char) rand;
        }
        return string;
    }

    public static void sortCharacters(char[] characters, int order) {
        bubbleSort(characters, order);
    }

    public static void bubbleSort(char[] characters, int flag) {
        for (int i = 0; i < characters.length; i++) {
            boolean isSwap = false;
            for (int j = 0; j < characters.length - i - 1; j++) {
                if (flag * characters[j] > flag * characters[j + 1]) {
                    char temp = characters[j];
                    characters[j] = characters[j + 1];
                    characters[j + 1] = temp;
                    isSwap = true;
                }
            }
            if (!isSwap) {
                break;
            }
        }
    }
}
