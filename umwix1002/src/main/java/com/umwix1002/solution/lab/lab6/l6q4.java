package com.umwix1002.solution.lab.lab6;

import static com.umwix1002.solution.lab.constants.CommonConstant.ZERO;

/**
 * @author Ng Zhi Yang
 */
public class l6q4 {
    public static void main(String[] args) {
        System.out.println(findGCD(24, 8));
        System.out.println(findGCD(200, 625));
    }

    /**
     * Find the greatest common divisor of two numbers.
     * Refers <a href="https://www.geeksforgeeks.org/program-to-find-gcd-or-hcf-of-two-numbers/">
     *     Program to Find GCD or HCF of Two Numbers</a> for more information.
     * @param a the first number
     * @param b the second number
     * @return the GCD of a and b
     */
    public static int findGCD(int a, int b) {
        return b == ZERO ? a : findGCD(b, a % b);
    }
}
