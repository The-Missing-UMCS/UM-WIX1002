package com.umwix1002.solution.lab.lab02;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l2q6 {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            NumberFormat numFormat = new DecimalFormat("0.######E0");

            System.out.print("Enter the amount of water in gram: ");
            double waterWeight = scanner.nextDouble() / 1000;

            System.out.print("Enter the initial temperature in Fahrenheit: ");
            double tempIni = convertFahrenheitToCelsius(scanner.nextDouble());

            System.out.print("Enter the final temperature in Fahrenheit: ");
            double tempFinal = convertFahrenheitToCelsius(scanner.nextDouble());

            double energy = waterWeight * (tempFinal - tempIni) * 4184;

            // Display 1
            System.out.printf("The energy needed is %.6e%n", energy);

            // Display 2
            System.out.println("The energy needed is " + numFormat.format(energy));
        }
    }
    
    public static Double convertFahrenheitToCelsius(double temp) {
        return (temp - 32) * 5 / 9;
    }
}
