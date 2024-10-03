package com.umwix1002.solution.lab.lab5;

import com.umwix1002.solution.lab.CommonConstant;

import java.util.Arrays;
import java.util.Random;

/**
 * This class demonstrates different methods to transpose a 3x3 integer matrix.
 * Refer to <a href="https://github.com/LimJY03/WIX1002_UM/blob/main/Lab%2005/L5Q4.java">L5Q4.java | Lim JY</a> for alternative solutions.
 * 
 * @author Ng Zhi Yang
 */
public class l5q4 {
    public static void main(String[] args) {
        int[][] matrix = getIntMatrix(3, 1, 9);
        printIntMatrix(matrix);

        int[][] transpose1 = transposeIntMatrixByHardCoding(matrix);
        printIntMatrix(transpose1);
        
        int[][] transpose2 = transposeIntMatrixByLooping(matrix);
        printIntMatrix(transpose2);
        
        int[][] transpose3 = transposeIntMatrixByPattern(matrix);
        printIntMatrix(transpose3);
    }
    
    public static int[][] transposeIntMatrixByPattern(int[][] matrix) {
        int tmp; int n;
        int[][] result = copy(matrix);
        for(int i = 0; i < result.length / 2; i++) {
            for(int j = i; j < result[i].length - 1 - i; j++) {
                n = result[i].length;
                tmp = result[i][j];
                result[i][j] = result[j][n - i - 1];
                result[j][n - i - 1] = result[n - i - 1][n - j - 1];
                result[n - i - 1][n - j - 1] = result[n - j - 1][i];
                result[n - j - 1][i] = tmp;
            }
        }
        return result;
    }
    
    public static int[][] transposeIntMatrixByLooping(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i = CommonConstant.ZERO; i < result.length; i++) {
            for(int j = result.length - CommonConstant.ZERO; j >= CommonConstant.ZERO; j--){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    
    public static int[][] transposeIntMatrixByHardCoding(int[][] matrix) {
        int[][] copy = copy(matrix);
        int[][] result = copy(matrix);

        // Corner
        result[0][0] = copy[2][0];
        result[2][0] = copy[2][2];
        result[2][2] = copy[0][2];
        result[0][2] = copy[0][0];

        // Side
        result[0][1] = copy[1][0];
        result[1][0] = copy[2][1];
        result[2][1] = copy[1][2];
        result[1][2] = copy[0][1];
        
        return result;
    }

    public static int[][] copy(int[][] src) {
        return Arrays.stream(src).map(int[]::clone).toArray(int[][]::new);
        // https://www.techiedelight.com/create-copy-of-2d-array-java/
    }
    
    public static int[][] getIntMatrix(int size, int min, int max) {
        int[][] matrix = new int[size][size];
        for(int i = CommonConstant.ZERO; i < matrix.length; i++) {
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
    }
}
