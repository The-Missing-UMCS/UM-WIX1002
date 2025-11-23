package com.umwix1002.solution.lab.lab03;

import java.util.Scanner;

public class l3q3 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the sales volume: ");
            int salesVolume = scanner.nextInt();

            double commission;
            if (salesVolume > 1000) {
                commission = 0.125;
            } else if (salesVolume > 500) {
                commission = 0.10;
            } else if (salesVolume > 100) {
                commission = 0.075;
            } else {
                commission = 0.05;
            }

            System.out.printf("The commission is %.2f", commission);
        }
    }
}
