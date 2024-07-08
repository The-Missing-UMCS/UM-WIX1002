package wix1002_2024_1.Q4;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Q4 {

    public static void main(String[] args) {
        int[][] seatingPlan = initializeSeatingPlan(5);
        printSeatingPlan(seatingPlan);
        SeatingAnalysisResult results = analyzeSeating(seatingPlan);
        System.out.println(results);
    }

    public static void printSeatingPlan(int[][] seatingPlan) {
        for (int[] row : seatingPlan)
            System.out.println(Arrays.toString(row));
    }

    public static int[][] initializeSeatingPlan(int dimension) {
        Random rand = new Random();
        int[][] seatingPlan = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++)
            for (int col = 0; col < dimension; col++)
                seatingPlan[row][col] = rand.nextBoolean() ? 1 : 0;
        return seatingPlan;
    }

    public static SeatingAnalysisResult analyzeSeating(int[][] seatingPlan) {
        int dimension = seatingPlan.length;
        int totalOccupiedSeats = 0;
        ArrayList<Integer> mostOccupiedRows = new ArrayList<>();
        int occupiedSeatsInRow;
        int maxOccupiedSeatsInRow = -1;

        for (int row = 0; row < dimension; row++) {
            occupiedSeatsInRow = 0;
            for (int col = 0; col < dimension; col++)
                occupiedSeatsInRow += seatingPlan[row][col];
            totalOccupiedSeats += occupiedSeatsInRow;

            if (occupiedSeatsInRow > maxOccupiedSeatsInRow) {
                maxOccupiedSeatsInRow = occupiedSeatsInRow;
                mostOccupiedRows.clear();
                mostOccupiedRows.add(row);
            } else if (occupiedSeatsInRow == maxOccupiedSeatsInRow) {
                mostOccupiedRows.add(row);
            }
        }

        int[] mostOccupiedRowsArray = mostOccupiedRows.stream().mapToInt(i -> i).toArray();
        return new SeatingAnalysisResult(totalOccupiedSeats, mostOccupiedRowsArray);
    }

    static class SeatingAnalysisResult {
        final int totalOccupiedSeats;
        final int[] mostOccupiedRow;
        final static String MOST_OCCUPIED_ROW_LABEL = "Most Occupied Row";
        final static String TOTAL_OCCUPIED_SEATS_LABEL = "Total Occupied Seats";

        SeatingAnalysisResult(int totalOccupiedSeats, int[] mostOccupiedRow) {
            this.totalOccupiedSeats = totalOccupiedSeats;
            this.mostOccupiedRow = mostOccupiedRow;
        }

        @Override
        public String toString() {
            return String.format("%s: %d, %s: %s",
                    TOTAL_OCCUPIED_SEATS_LABEL, totalOccupiedSeats,
                    MOST_OCCUPIED_ROW_LABEL, Arrays.toString(mostOccupiedRow));
        }
    }
}
