package com.umwix1002.solution.pastyear.PastYear2023;

public class Q1 {
    public static void main(String[] args) {
        int rand = (int) (Math.random() * (10000 + 1));
        System.out.println("Generated number: " + rand);
        System.out.println("Number in reverse order: " + reverse(rand));
        System.out.println("The sum of all integers: " + sumOfDigit(rand));
    }

    public static int reverse(int n) {
        int rev = 0;
        for (int tmp = n; tmp > 0; tmp /= 10) {
            rev = rev * 10 + tmp % 10;
        }
        return rev;
    }

    public static int sumOfDigit(int n) {
        int sum = 0;
        for (int tmp = n; tmp > 0; tmp /= 10) {
            sum += tmp % 10;
        }
        return sum;
    }
}
