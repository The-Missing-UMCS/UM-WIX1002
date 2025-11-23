package com.umwix1002.solution.lab.lab05;

import java.util.Arrays;
import java.util.Random;

public class l5q4 {

    public static void main(String[] args) {
        // 1. Create a matrix and check its values
        int[][] matrix = new int[][]{
            {1, 5, 7},
            {3, 6, 9},
            {5, 3, 8}
        };
        // If you want to create random matrix, uncomment the following code
        // int[][] matrix = createMatrix();
        printMatrix("Original", matrix);

        // Method 1: Hard Coding
        int[][] copy = copy(matrix);

        // Corner
        copy[0][0] = matrix[2][0];
        copy[2][0] = matrix[2][2];
        copy[2][2] = matrix[0][2];
        copy[0][2] = matrix[0][0];

        // Side
        copy[0][1] = matrix[1][0];
        copy[1][0] = matrix[2][1];
        copy[2][1] = matrix[1][2];
        copy[1][2] = matrix[0][1];

        printMatrix("Hardcoded", copy);

        // Method 2: Using for loop to iterate the elements reversely
        System.out.println("Reverse Print matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // Method 3: Using Pattern Recognition
        int tmp, n;
        matrix = createMatrix(4, 4);
        printMatrix("Original", matrix);
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix[i].length - 1 - i; j++) {
                n = matrix[i].length;
                tmp = matrix[i][j];
                /*
                Anticlockwise (90 degree)

                matrix[i][j] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = tmp;
                */

                // Clockwise (90 degree)
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tmp;
            }
        }
        printMatrix("Pattern Recognition", matrix);

        /*
         * Method 4: Get user input in reversely
         * Credit to: https://github.com/LimJY03/WIX1002_UM/blob/main/Lab%2005/L5Q4.java
         */
//        try (Scanner scanner = new Scanner(System.in)) {
//            String[][] strMatrix = new String[3][3];
//
//            for (int i = 2; i >= 0; i--) {
//                for (int j = 0; j < 3; j++) {
//                    strMatrix[j][i] = scanner.next();
//                }
//            }
//
//            System.out.println(Arrays.deepToString(strMatrix));
//        }
    }

    private static int[][] createMatrix() {
        Random random = new Random();
        int min = 1, max = 9, range = max - min + 1;

        int[][] matrix = new int[3][3];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = random.nextInt(range) + min;
            }
            // You can use the following Java syntax to simplify the creation
            // matrix[row] = random.ints(3, 1, 9).toArray();
        }
        return matrix;
    }

    private static int[][] createMatrix(int rows, int cols) {
        Random random = new Random();
        int min = 1, max = 9, range = max - min + 1;

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = random.nextInt(range) + min;
            }
            // You can use the following Java syntax to simplify the creation
            // matrix[row] = random.ints(3, 1, 9).toArray();
        }
        return matrix;
    }

    private static int[][] copy(int[][] src) {
        return Arrays.stream(src).map(int[]::clone).toArray(int[][]::new);
        // https://www.techiedelight.com/create-copy-of-2d-array-java/
    }

    private static void printMatrix(String label, int[][] matrix) {
        System.out.printf("%s matrix:%n", label);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
