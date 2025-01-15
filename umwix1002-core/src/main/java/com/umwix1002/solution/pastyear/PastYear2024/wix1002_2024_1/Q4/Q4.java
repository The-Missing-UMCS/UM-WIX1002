package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q4;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Q4 {
    private static final String MOST_OCCUPIED_ROW_LABEL = "Most Occupied Row";
    private static final String TOTAL_OCCUPIED_SEATS_LABEL = "Total Occupied Seats";

    public static void main(String[] args) {
        int[][] seatingPlan = initializeSeatingPlan(5);
        printSeatingPlan(seatingPlan);
        SeatingAnalysisResult results = analyzeSeating(seatingPlan);
        displayAnalysisResult(results);
    }

    private static void printSeatingPlan(int[][] seatingPlan) {
        Arrays.stream(seatingPlan)
            .map(Arrays::toString)
            .forEach(System.out::println);
    }

    private static int[][] initializeSeatingPlan(int dimension) {
        // Method 1: Imperative programming
        //        Random rand = new Random();
        //        int[][] seatingPlan = new int[dimension][dimension];
        //        for (int row = 0; row < dimension; row++)
        //            for (int col = 0; col < dimension; col++)
        //                seatingPlan[row][col] = rand.nextBoolean() ? 1 : 0;
        //        return seatingPlan;

        // Method 2: Declarative Programming
        Random random = new Random();
        return random.ints(dimension, 0, 2)
            .mapToObj(row -> random.ints(dimension, 0, 2).toArray())
            .toArray(int[][]::new);
    }

    public static SeatingAnalysisResult analyzeSeating(int[][] seatingPlan) {
        int totalOccupiedSeats = countOccupiedSeats(seatingPlan);
        int[] mostOccupiedRowsArray = findMostOccupiedRows(seatingPlan);
        return new SeatingAnalysisResult(totalOccupiedSeats, mostOccupiedRowsArray);
    }

    private static int countOccupiedSeats(int[][] seatingPlan) {
        return Arrays.stream(seatingPlan)
            .flatMapToInt(Arrays::stream)
            .sum();
    }

    private static int[] findMostOccupiedRows(int[][] seatingPlan) {
        // Method 1: Imperative programming
        //        int maxOccupiedSeats = -1;
        //        ArrayList<Integer> mostOccupiedRows = new ArrayList<>();
        //        for (int row = 0; row < seatingPlan.length; row++) {
        //            int occupiedSeats = Arrays.stream(seatingPlan[row]).sum();
        //            if (occupiedSeats > maxOccupiedSeats) {
        //                maxOccupiedSeats = occupiedSeats;
        //                mostOccupiedRows.clear();
        //                mostOccupiedRows.add(row);
        //            } else if (occupiedSeats == maxOccupiedSeats) {
        //                mostOccupiedRows.add(row);
        //            }
        //        }
        //        return mostOccupiedRows.stream().mapToInt(i -> i).toArray();

        // Method 2: Declarative Programming
        int maxOccupiedSeats = Arrays.stream(seatingPlan)
            .mapToInt(row -> Arrays.stream(row).sum())
            .max()
            .orElse(-1);

        return IntStream.range(0, seatingPlan.length)
            .filter(row -> Arrays.stream(seatingPlan[row]).sum() == maxOccupiedSeats)
            .toArray();
    }

    private static void displayAnalysisResult(SeatingAnalysisResult results) {
        System.out.printf("%s: %d, %s: %s%n",
            TOTAL_OCCUPIED_SEATS_LABEL, results.totalOccupiedSeats(),
            MOST_OCCUPIED_ROW_LABEL, Arrays.toString(results.mostOccupiedRow()));
    }
}
