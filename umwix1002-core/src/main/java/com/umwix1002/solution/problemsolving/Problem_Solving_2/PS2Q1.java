package com.umwix1002.solution.problemsolving.Problem_Solving_2;

import java.util.Random;
import java.util.Scanner;

public class PS2Q1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Random random = new Random();
            System.out.print("Enter the number of stuff [N]: ");
            final int N = scanner.nextInt();

            int count = 0;
            for (int i = 0; i < N; i++) {
                int id = random.nextInt(10000, 100000);
                System.out.println("Staff ID: " + id);
                if ((id / 1000) % 2 == 1 && (id / 10) % 2 == 0) {
                    System.out.println("Weekday on");
                    count++;
                } else {
                    System.out.println("Weekday off");
                }
            }

            System.out.println("The number of staffs work during weekend is " + count);
        }
    }
}
