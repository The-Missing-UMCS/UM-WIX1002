package com.umwix1002.solution.lab.lab04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author Ng Zhi Yang
 */
public class l4q8 {

    public static void main(String[] args) {
        int min = 5, max = 30, range = max - min + 1;
        int n = new Random().nextInt(range) + min;
        System.out.printf("First %d prime number(s):%n", n);
        int[] arr = new int[n];
        arr[0] = 2;

        String format = " %-25s : %s%n";
        int count;

        // 1. Using for loop
        count = 1; // arr[0] = 2, so count always 1
        for (int number = 3; count < n; number += 2) {
            // Check if the current value is prime number
            boolean isPrimeNumber = true;
            for (int factor = 2; factor <= Math.sqrt(number); factor++) {
                boolean isDivisible = number % factor == 0;
                if (isDivisible) {
                    isPrimeNumber = false;
                    break;
                }
            }

            // If the current number is a prime number, add it to the array
            if (isPrimeNumber) {
                arr[count++] = number;
            }
        }
        System.out.printf(format, "for loop", Arrays.toString(arr));

        // 2. Using while loop
        count = 1; // arr[0] = 2, so count always 1
        int number = 3;
        while (count < n) {
            boolean isPrimeNumber = true;
            for (int factor = 2; factor <= Math.sqrt(number); factor++) {
                boolean isDivisible = number % factor == 0;
                if (isDivisible) {
                    isPrimeNumber = false;
                    break;
                }
            }

            // If the current number is a prime number, add it to the array
            if (isPrimeNumber) {
                arr[count++] = number;
            }

            number++;
        }
        System.out.printf(format, "while loop", Arrays.toString(arr));

        // 3. Use getFirstNPrimeNumbers
        System.out.printf(format, "getFirstNPrimeNumbers", getFirstNPrimeNumbers(n));

        // 3. Use getFirstNPrimeNumbers2
        System.out.printf(format, "getFirstNPrimeNumbers2", getFirstNPrimeNumbers(n));
    }

    private static List<Integer> getFirstNPrimeNumbers(int n) {
        if (n <= 0) {
            return List.of();
        }
        List<Integer> primeNumbers = new ArrayList<>();
        for (int val = 2; primeNumbers.size() < n; val++) {
            if (isPrimeNumber(val)) {
                primeNumbers.add(val);
            }
        }
        return List.copyOf(primeNumbers);
    }

    private static boolean isPrimeNumber(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getFirstNPrimeNumbers2(int n) {
        if (n <= 0) {
            return List.of();
        }
        List<Integer> primeNumbers = new ArrayList<>();
        primeNumbers.add(2);

        for (int val = 3; primeNumbers.size() < n; val += 2) {
            boolean isPrimeNumber = true;
            int sqrt = (int) Math.sqrt(val);

            for (int primeNumber : primeNumbers) {
                if (primeNumber > sqrt) {
                    break;
                }
                boolean isDivisible = val % primeNumber == 0;
                if (isDivisible) {
                    isPrimeNumber = false;
                    break;
                }
            }
            if (isPrimeNumber) {
                primeNumbers.add(val);
            }
        }
        return primeNumbers;
    }


}
