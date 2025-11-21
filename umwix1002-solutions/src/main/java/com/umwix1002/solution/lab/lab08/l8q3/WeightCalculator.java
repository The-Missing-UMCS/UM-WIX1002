package com.umwix1002.solution.lab.lab08.l8q3;

public class WeightCalculator {

    /*
     * This method is more recommended as it promotes better separation of concern
     */
    public WeightCalcResult calculate(double height, int age) {
        double recommendedWeight = calculateRecWeight(height, age);
        return new WeightCalcResult(height, age, recommendedWeight);
    }

    public void calculateAndShow(double height, int age) {
        double recommendedWeight = calculateRecWeight(height, age);
        System.out.printf("Your age is %d.\n", age);
        System.out.printf("Your height is %.2fcm.\n", height);
        System.out.printf("Your recommended weight is %.2fkg.\n", recommendedWeight);
    }

    public double calculateRecWeight(double height, int age) {
        return ((height - 100) + ((double) age / 10)) * 0.9;
    }
}
