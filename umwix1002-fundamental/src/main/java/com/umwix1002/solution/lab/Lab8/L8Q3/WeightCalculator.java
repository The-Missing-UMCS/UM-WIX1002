package com.umwix1002.solution.lab.Lab8.L8Q3;

public class WeightCalculator {
    public double calcRecWeight(double height, int age) {
        return ((height - 100) + ((double) age / 10)) * 0.9;
    }

    public void calculateAndShow(double height, int age) {
        System.out.printf("Your age is %d.\n", age);
        System.out.printf("Your height is %.2fcm.\n", height);
        System.out.printf("Your recommended weight is %.2fkg.\n", calcRecWeight(height, age));
    }
}
