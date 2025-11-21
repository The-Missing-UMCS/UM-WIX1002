package com.umwix1002.solution.pastyear.PastYear2017.wix1002_2017_1.Q4;

import java.util.Scanner;

public class Q4Main {
    public static void main(String[] args) {
        final String MSG = "%s complex number. Enter a number for the %s part: ";
        Scanner sc = new Scanner(System.in);
        Complex first = new Complex(
            getDoubleInput(sc, String.format(MSG, "First", "real")),
            getDoubleInput(sc, String.format(MSG, "First", "imaginary")));
        Complex second = new Complex(
            getDoubleInput(sc, String.format(MSG, "Second", "real")),
            getDoubleInput(sc, String.format(MSG, "Second", "imaginary")));

        System.out.println("First complex number: " + first);
        System.out.println("Second complex number: " + second);
        System.out.println("Addition of the two complex numbers: " + Complex.addComplexNum(first, second));
        System.out.println("Subtraction of the two complex numbers: " + Complex.subtractComplexNum(first, second));
    }

    public static double getDoubleInput(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.nextDouble();
    }
}
