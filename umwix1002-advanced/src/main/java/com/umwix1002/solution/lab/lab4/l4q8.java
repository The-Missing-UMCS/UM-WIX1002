package com.umwix1002.solution.lab.lab4;

import com.umwix1002.solution.lab.constants.CommonConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.umwix1002.solution.lab.constants.CommonConstant.BLANK;
import static com.umwix1002.solution.lab.constants.CommonConstant.ONE;

/**
 * @author Ng Zhi Yang
 */
public class l4q8 {
    public static void main(String[] args) {
        int n = new Random().nextInt(100);
        System.out.printf("First %d prime number%s:\n", n, (n > ONE) ? "s" : BLANK);
        System.out.println(getFirstNPrimeNumbers(n));
    }

    public static List<Integer> getFirstNPrimeNumbers(int n) {
        if(n <= 0) {
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

    public static boolean isPrimeNumber(int n) {
        if(n < 2) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
