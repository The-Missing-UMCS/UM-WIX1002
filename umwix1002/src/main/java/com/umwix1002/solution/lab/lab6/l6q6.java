package com.umwix1002.solution.lab.lab6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.umwix1002.solution.lab.constants.CommonConstant.*;
import static com.umwix1002.solution.lab.util.MyMathUtil.*;

/**
 * @author Ng Zhi Yang
 */
public class l6q6 {
    private static final int N = 20;
    
    public static void main(String[] args) {
        String pattern = "First %d %-20s: %s\n";
        System.out.printf(pattern, N, "Palindromic Prime", getFirstByCondition(N, l6q6::isPalindromicPrime));
        System.out.printf(pattern, N, "Emirp", getFirstByCondition(N, l6q6::isEmirp));
        System.out.printf(pattern, N, "Prime", getFirstByCondition(N, l6q6::isPrime));
    }
    
    public static List<Integer> getFirstByCondition(int n, Predicate<Integer> condition) {
        List<Integer> result = new ArrayList<>();
        for (int i = ZERO; result.size() < n; i++) {
            if(condition.test(i)) {
                result.add(i);
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
        if(n == TWO) {
            return true;
        }
        if(n < TWO || isEven(n)) {
            return false;
        }
        for(int i = 3; i <= Math.sqrt(n); i += TWO) {
            if (isDivisible(n, i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromic(int n) {
        if (isNegative(n) || isDivisible(n, TEN) && n != ZERO) {
            return false;
        }
        int tmp = ZERO;
        // reverse half of the N
        while(tmp < n) {
            tmp = tmp * TEN + n % TEN;
            n /= TEN;
        }
        // check if the remaining half is equal to the reversed half
        return (tmp == n || (tmp / TEN) == n);
    }

    public static int reverse(int n) {
        int tmp = ZERO;
        while(n > ZERO) {
            tmp = tmp * TEN + n % TEN;
            n /= TEN;
        }
        return tmp;
    }
}
