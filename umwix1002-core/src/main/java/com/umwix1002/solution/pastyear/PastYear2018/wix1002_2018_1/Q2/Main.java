package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_1.Q2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int AAA = 0;
    private static final int AA = 1;
    private static final int A = 2;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter N number: ");
            final int N = sc.nextInt();
            int[] numbers = getRandomNumbers(N, 50, 150);
            System.out.println("The random numbers are: " + arrayToString(numbers));
            int[] freq = measureFrequency(numbers);
            System.out.printf("""
                Group AAA : %d
                Group AA : %d
                Group A : %d%n""", freq[AAA], freq[AA], freq[A]);
        }
    }

    public static int[] measureFrequency(int[] numbers) {
        int[] freq = new int[3];
        Arrays.stream(numbers).forEach(n -> freq[getGroup(n)] += 1);
        return freq;
        // can be done using enhanced for loop
        // for (int number : numbers) {
        // int group = getGroup(number);
        // freq[group]++;
        // }
        // return freq;
    }

    public static int getGroup(int val) {
        int digit = val % 10;
        if (digit >= 7) {
            return A;
        }
        return digit >= 4 ? AA : AAA;
    }

    public static int[] getRandomNumbers(int size, int min, int max) {
        Random rand = new Random();
        return rand.ints(size, min, max).toArray();
        // can be done using enhanced for loop
        // int[] numbers = new int[size];
        // for (int i = 0; i < size; i++) {
        // numbers[i] = rand.nextInt(max - min + 1) + min;
        // }
        // return numbers;
    }

    static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array)
            sb.append(num).append(" ");
        return sb.toString().trim();
    }
}
