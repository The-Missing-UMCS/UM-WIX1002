package com.umwix1002.solution.lab.lab2;

import java.util.Random;

public class l2q5 {
    public static void main(String[] args) {
        int rand = new Random().nextInt(0, 1000);
        System.out.println("The random number generated is " + rand);
        System.out.println("The sum of digits using For loop is   : " + sumDigitsUsingFor(rand));
        System.out.println("The sum of digits using While loop is : " + sumDigitsUsingWhile(rand));
    }
    
    public static Integer sumDigitsUsingFor(Integer number) {
       int sum = 0;
       for(; number > 0; number /= 10) {
           sum += number % 10;
       }
       return sum;
    }
    
    public static Integer sumDigitsUsingWhile(Integer number) {
        int sum = 0;
        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
