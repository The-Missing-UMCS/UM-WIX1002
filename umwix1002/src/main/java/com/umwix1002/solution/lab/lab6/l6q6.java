package com.umwix1002.solution.lab.lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.umwix1002.solution.lab.constants.CommonConstant.ZERO;

public class l6q6 {
    public static void main(String[] args) {
        int n = 20;
        String pattern = "First %d %-20s: %s\n";
        System.out.printf(pattern, n, "Palindromic Prime", getFirstByCondition(n, l6q6::isPalindromicPrime));
        System.out.printf(pattern, n, "Emirp", getFirstByCondition(n, l6q6::isEmirp));
        System.out.printf(pattern, n, "Prime", getFirstByCondition(n, l6q6::isPrime));
    }
    
    public static List<Integer> getFirstByCondition(int n, Predicate<Integer> condition) {
        List<Integer> result = new ArrayList<>();
        for (int i = ZERO, count = ZERO; count < n; i++) {
            if(condition.test(i)) {
                result.add(i);
                count++;
            }
        }
        return result;
    }

    public static boolean isPalindromicPrime(int n) {
        return (isPalindromic(n) && isPrime(n));
    }

    public static boolean isEmirp(int n) {
        return (!isPalindromic(n) && isPrime(n) && isPrime(reverse(n)));
    }

    public static boolean isPrime(int n) {
        if(n == 2) {
            return true;
        }
        if(n < 2 || n % 2 == 0) {
            return false;
        }
        for(int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromic(int n) {
        if (n < 0 || n % 10 == 0) {
            return false;
        }
        int tmp = 0;
        while(tmp < n) {
            tmp = tmp * 10 + n % 10;
            n /= 10;
        }
        return (tmp == n || (tmp / 10) == n);
    }

    public static int reverse(int n) {
        int tmp = 0;
        while(n != 0) {
            tmp = tmp * 10 + n % 10;
            n /= 10;
        }
        return tmp;
    }
}
