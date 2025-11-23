package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // 1. Create matrix
        Random random = new Random();
        int[][] seating = new int[5][5];

        for (int row = 0; row < seating.length; row++) {
            for (int col = 0; col < seating[row].length; col++) {
                seating[row][col] = random.nextBoolean() ? 1 : 0;
            }
        }

        // 1.
        for (int row = 0; row < seating.length; row++) {
            for (int col = 0; col < seating[row].length; col++) {
                System.out.print(seating[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // 2.
        for (int[] row : seating) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }

        // 2. Analyze
        // 2.1 Count total occupied seats
        int totalOccupiedSeats = 0;

        // 2.2 Find most occupied row
        int maxOccupiedSeats = -1;
        int mostOccupiedRow = -1;

        for (int row = 0; row < seating.length; row++) {
            int currentRowOccupiedSeats = 0;
            for (int col = 0; col < seating.length; col++) {
                totalOccupiedSeats += seating[row][col];
                currentRowOccupiedSeats += seating[row][col];
            }

            // 比较当前行的座位数是否大于最大值
            if (currentRowOccupiedSeats > maxOccupiedSeats) {
                maxOccupiedSeats = currentRowOccupiedSeats;
                mostOccupiedRow = row;
            }
        }

        System.out.println("Total occupied seats: " + totalOccupiedSeats);
        System.out.println("Most occupied row: " + mostOccupiedRow);
    }
}
