package com.umwix1002.solution.lab.lab4;

import java.util.Random;

/**
 * @author Ng Zhi Yang
 */
public class l4q6 {
    public static void main(String[] args) {
        int randomNumber = new Random().nextInt(Integer.MAX_VALUE);
        System.out.println("Random number = " + randomNumber);
        for(int i = 0; randomNumber > 0; randomNumber /= 10, i++) {
            int digit = randomNumber % 10;
            System.out.printf("%15d = %d\n", ((int) Math.pow(10, i)), digit);
        }
    }
}
