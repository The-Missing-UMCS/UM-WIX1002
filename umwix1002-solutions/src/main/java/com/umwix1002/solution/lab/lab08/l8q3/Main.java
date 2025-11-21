package com.umwix1002.solution.lab.lab08.l8q3;

public class Main {

    public static void main(String[] args) {
        WeightCalculator weightCalculator = new WeightCalculator();
        int height = 170;
        int age = 21;

        // Approach 1
        WeightCalcResult result = weightCalculator.calculate(height, age);
        System.out.printf("Your age is %d.\n", result.age());
        System.out.printf("Your height is %.2fcm.\n", result.height());
        System.out.printf("Your recommended weight is %.2fkg.\n", result.recommendedWeight());

        // Approach 2
        weightCalculator.calculateAndShow(height, age);
    }
}
