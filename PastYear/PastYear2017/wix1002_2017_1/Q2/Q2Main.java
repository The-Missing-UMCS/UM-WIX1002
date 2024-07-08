package wix1002_2017_1.Q2;

import java.util.Scanner;

public class Q2Main {
    public static double computeFee(double initialFee, double incrementRate, int years) {
        return initialFee * Math.pow(1 + incrementRate / 100, years > 0 ? years - 1 : 0);
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextDouble();
    }

    public static int getIntInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double initialFee = getDoubleInput(scanner, "Enter the initial tuition fee (year 1): ");
        double incrementRate = getDoubleInput(scanner, "Enter the yearly increment rate (e.g., 5.2 for 5.2%): ");
        int years = getIntInput(scanner, "Enter the year you wish to compute the tuition for: ");
        double computedFee = computeFee(initialFee, incrementRate, years);
        System.out.printf("Computed tuition fee for year %d is %.2f", years, computedFee);
    }
}
