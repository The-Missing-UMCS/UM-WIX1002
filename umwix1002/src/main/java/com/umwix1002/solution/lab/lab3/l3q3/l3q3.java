package com.umwix1002.solution.lab.lab3.l3q3;

import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l3q3 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            double commission = 0;
            System.out.print("Enter the sales volume: ");
            int salesVolume = scanner.nextInt();
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
