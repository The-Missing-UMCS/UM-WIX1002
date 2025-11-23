package com.umwix1002.solution.lab.lab06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static com.umwix1002.solution.lab.constants.CommonConstant.TEN;
import static com.umwix1002.solution.lab.util.MyMathUtil.*;

/**
 * @author Ng Zhi Yang
 */
public class l6q6b {
    private static final int N = 20;

    public static void main(String[] args) {
        String pattern = "First %d %-20s: %s\n";
        System.out.printf(pattern, N, "Palindromic Prime", getFirstByCondition(N, l6q6b::isPalindromicPrime));
        System.out.printf(pattern, N, "Emirp", getFirstByCondition(N, l6q6b::isEmirp));
        System.out.printf(pattern, N, "Prime", getFirstByCondition(N, l6q6b::isPrime));
    }

    public static List<Integer> getFirstByCondition(int n, Predicate<Integer> condition) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; result.size() < n; i++) {
            if (condition.test(i)) {
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
        if (n == 2) {
            return true;
        }
        if (n < 2 || isEven(n)) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (isDivisible(n, i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromic(int n) {
        if (isNegative(n) || isDivisible(n, 10) && n != 0) {
            return false;
        }
        int tmp = 0;
        // reverse half of the N
        while (tmp < n) {
            tmp = tmp * 10 + n % 10;
            n /= 10;
        }
        // check if the remaining half is equal to the reversed half
        return (tmp == n || (tmp / TEN) == n);
    }

    public static int reverse(int n) {
        int tmp = 0;
        while (n > 0) {
            tmp = tmp * 10 + n % 10;
            n /= 10;
        }
        return tmp;
    }
}
