package com.umwix1002.solution.lab.lab8.l8q3;

public class Main {
    public static void main(String[] args) {
        WeightCalculator wc = new WeightCalculator(170, 21);
        System.out.printf("Your age is %d.\n", wc.getAge());
        System.out.printf("Your height is %.2fcm.\n", wc.getHeight());
        System.out.printf("Your recommended weight is %.2fkg.\n", wc.getRecWeight());
    }
}
