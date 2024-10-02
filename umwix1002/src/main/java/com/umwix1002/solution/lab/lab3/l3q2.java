package com.umwix1002.solution.lab.lab3;

/**
 * @author Ng Zhi Yang
 */
public class l3q2 {
    public static void main(String[] args) {
        int randomNum = (int)(Math.random() * 6);
        String[] numbers = {"zero", "one", "two", "three", "four", "five"};
        System.out.printf("%d is %s", randomNum, numbers[randomNum]);
    }
}
