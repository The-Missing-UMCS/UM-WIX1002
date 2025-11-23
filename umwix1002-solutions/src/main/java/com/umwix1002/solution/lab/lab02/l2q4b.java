package com.umwix1002.solution.lab.lab02;

import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l2q4b {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the time in seconds: ");
            long secondInput = scanner.nextLong();
            long seconds = secondInput % 60;
            long minutes = (secondInput % (60 * 60)) / 60;
            long hours = secondInput / (60 * 60);
            System.out.printf("%d seconds is %d hours %d minutes %d seconds", secondInput, hours, minutes, seconds);
        }
    }
}
