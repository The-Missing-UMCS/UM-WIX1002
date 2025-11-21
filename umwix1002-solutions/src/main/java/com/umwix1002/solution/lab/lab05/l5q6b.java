package com.umwix1002.solution.lab.lab05;

import com.umwix1002.solution.lab.util.CommonUtils;

/**
 * @author Ng Zhi Yang
 */
public class l5q6b {
    public static void main(String[] args) {
        final int numberOfRows = 5;
        int[][] pascalTriangle = getPascalTriangle(numberOfRows);
        printPascalTriangle(pascalTriangle);
    }

    public static int[][] getPascalTriangle(int rowNum) {
        int[][] pascal = new int[rowNum][rowNum];
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col <= row; col++) {
                boolean atEitherEnd = col == 0 || col == row;
                if (atEitherEnd) {
                    // Fill the one at both the leftmost and rightmost.
                    pascal[row][col] = 1;
                } else {
                    // simple arithmetic calculation
                    int[] prevRow = pascal[row - 1];
                    pascal[row][col] = prevRow[col - 1] + prevRow[col];
                }
            }
        }
        return pascal;
    }

    public static void printPascalTriangle(int[][] pascalTriangle) {
        CommonUtils.checkIfSquareMatrix(pascalTriangle);
        int rowNum = pascalTriangle.length;
        for (int row = 0; row < rowNum; row++) {
            for (int col = 0; col < rowNum; col++) {
                System.out.printf("%4d", pascalTriangle[row][col]);
            }
            System.out.println();
        }
    }
}
