package com.umwix1002.solution.tutorial.Tutorial8.T8Q2;

public class Digit {
    private int num;

    Digit(int num) {
        this.num = num;
    }

    public int digitMultiplication() {
        int mul = 1; // multiplication
        int tmp = num; // temporary

        while (tmp > 0) {
            mul *= (tmp % 10);
            tmp /= 10;
        }

        return mul;
    }

    public void showDigitMul() {
        System.out.println(this.digitMultiplication());
    }
}