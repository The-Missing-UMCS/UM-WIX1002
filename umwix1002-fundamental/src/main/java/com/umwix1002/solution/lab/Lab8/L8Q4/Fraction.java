package com.umwix1002.solution.lab.Lab8.L8Q4;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.checkerframework.checker.units.qual.A;

import java.util.Scanner;

@Data
@AllArgsConstructor(staticName = "of")
public class Fraction {
    private int numerator;
    private int denominator;

    public int findGCD(int x, int y) {
        return y == 0 ? x : findGCD(y, x % y);
    }

    public int getGCD() {
        return findGCD(this.numerator, this.denominator);
    }

    public String getSimplestFraction() {
        int gcd = getGCD();
        return (numerator / gcd) + "/" + (denominator / gcd);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
