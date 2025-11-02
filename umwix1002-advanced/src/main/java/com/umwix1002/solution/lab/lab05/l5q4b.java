package com.umwix1002.solution.lab.lab05;

import com.umwix1002.solution.lab.constants.CommonConstant;
import com.umwix1002.solution.lab.util.CommonUtils;

import java.util.Arrays;
import java.util.Random;

public class l5q4b {
    public static void main(String[] args) {
        int[][] matrix = getIntMatrix(4, 1, 9);
        printIntMatrix(matrix);

        int[][] transpose1 = transposeIntMatrixByLooping(matrix);
        printIntMatrix(transpose1);

        int[][] transpose2 = transposeIntMatrixByPattern(matrix);
        printIntMatrix(transpose2);
    }

    public static int[][] transposeIntMatrixByPattern(int[][] matrix) {
        CommonUtils.checkIfSquareMatrix(matrix);
        int[][] result = deepCopy(matrix);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = row + 1; col < matrix.length; col++) {
                int tmp = result[row][col];
                result[row][col] = result[col][row];
                result[col][row] = tmp;
            }
        }
        return result;
    }

    public static int[][] transposeIntMatrixByLooping(int[][] matrix) {
        CommonUtils.checkIfSquareMatrix(matrix);
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = result.length - 1; j >= 0; j--) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static int[][] deepCopy(int[][] src) {
        return Arrays.stream(src).map(int[]::clone).toArray(int[][]::new);
    }

    public static int[][] getIntMatrix(int size, int min, int max) {
        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new Random().ints(size, min, max).toArray();
        }
        return matrix;
    }

    public static void printIntMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + CommonConstant.SPACE);
            }
            System.out.println();
        }
        System.out.println();
    }
}
