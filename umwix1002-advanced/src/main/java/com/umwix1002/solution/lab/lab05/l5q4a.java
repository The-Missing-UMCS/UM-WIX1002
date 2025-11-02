package com.umwix1002.solution.lab.lab05;

import java.util.Arrays;
import java.util.Random;

public class l5q4a {
    public static void main(String[] args) {
        int tmp, n;

        // Original Array
        int[][] matrix = new int[3][3];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new Random().ints(3, 1, 9).toArray();
        }

        printMatrix(matrix);

        // Method 1
        int[][] copy = copy(matrix);

        // Corner
        matrix[0][0] = copy[2][0];
        matrix[2][0] = copy[2][2];
        matrix[2][2] = copy[0][2];
        matrix[0][2] = copy[0][0];

        // Side
        matrix[0][1] = copy[1][0];
        matrix[1][0] = copy[2][1];
        matrix[2][1] = copy[1][2];
        matrix[1][2] = copy[0][1];

        System.out.println();
        printMatrix(matrix);

        // Method 2
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix.length - 1; j >= 0; j--) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }

        // Method 3
        System.out.println();
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix[i].length - 1 - i; j++) {
                n = matrix[i].length;
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = tmp;
            }
        }

        // Method credit to: https://github.com/LimJY03/WIX1002_UM/blob/main/Lab%2005/L5Q4.java
		/*
		Scanner sc = new Scanner(System.in);
        String[][] matrix = new String[3][3];

        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                matrix[j][i] = sc.next();
            }
        }

        String temp = String.join(
                "\n",
                String.join(" ", matrix[0]),
                String.join(" ", matrix[1]),
                String.join(" ", matrix[2])
        );

        System.out.println(temp);

        sc.close();
		 */
    }

    public static int[][] copy(int[][] src) {
        return Arrays.stream(src).map(int[]::clone).toArray(int[][]::new);
        // https://www.techiedelight.com/create-copy-of-2d-array-java/
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
