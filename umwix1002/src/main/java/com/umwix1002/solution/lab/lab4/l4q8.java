package com.umwix1002.solution.lab.lab4;

import com.umwix1002.solution.lab.CommonConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Ng Zhi Yang
 */
public class l4q8 {
    public static void main(String[] args) {
        int n = new Random().nextInt(100);
        System.out.printf("First %d prime number%s:\n", n, (n > CommonConstant.ONE) ? "s" : CommonConstant.EMPTY_STRING);
        System.out.println(getFirstNPrimeNumbers(n));
    }

    /**
     * Get the first n prime numbers
     * @param n number of prime numbers to be returned
     * @return list of prime numbers
     */
    public static List<Integer> getFirstNPrimeNumbers(int n) {
        if(n <= CommonConstant.ZERO) {
            return new ArrayList<>();
        }
        List<Integer> primeNumbers = new ArrayList<>();
        for(int val = 2, count = 0; count < n; val++) {
            if(isPrimeNumber(val)) {
                primeNumbers.add(val);
                count++;
            }
        }
        return primeNumbers;
    }

    /**
     * Determine if a number is prime number
     * @param n number to be checked
     * @return true if n is prime number, false otherwise
     */
    public static boolean isPrimeNumber(int n) {
        if(n < 2) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == CommonConstant.ZERO) {
                return false;
            }
        }
        return true;
    }
}
