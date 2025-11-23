package com.umwix1002.solution.problemsolving.ps2223s01;

import java.util.Scanner;

public class PS1Q1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the coordinate x and y: ");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter the move: ");
            String move = scanner.nextLine().toUpperCase();

            System.out.printf("Initial Coordinate: (%d, %d)%n", x, y);

            for(char ch : move.toCharArray()) {
                switch(ch) {
                    case 'R' -> x++;
                    case 'L' -> x--;
                    case 'U' -> y++;
                    case 'D' -> y--;
                }
            }

            System.out.printf("Final Coordinate: (%d, %d)%n", x, y);
        }
    }
}
