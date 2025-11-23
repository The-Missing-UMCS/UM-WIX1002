package com.umwix1002.solution.lab.lab03;

import java.util.Random;

public class l3q2 {

    public static void main(String[] args) {
        int randomNum = new Random().nextInt(10);
        String[] numbers = {"zero", "one", "two", "three", "four", "five"};
        System.out.printf("%d is %s", randomNum, numbers[randomNum]);
    }
}
