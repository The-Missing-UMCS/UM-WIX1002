package com.umwix1002.solution.lab.lab08.l8q4;

public class Main {
    public static void main(String[] args) {
        Fraction fraction = new Fraction(24, 80);
        System.out.println(fraction);
        System.out.println(fraction.reduce());
        System.out.println(fraction.getSimplestFraction());
    }
}
