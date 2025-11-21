package com.umwix1002.solution.lab.lab02;

import java.time.Duration;
import java.util.Scanner;

/**
 * @author Ng Zhi Yang
 */
public class l2q4c {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the time in seconds: ");
            long input = scanner.nextLong();
            Duration duration = Duration.ofSeconds(input);
            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;
            long seconds = duration.getSeconds() % 3600;
            System.out.printf("%d:%02d:%02d%n", hours, minutes, seconds);
        }
    }
}
