package com.umwix1002.solution.lab.lab5;

import com.umwix1002.solution.lab.CommonConstant;
import com.umwix1002.solution.lab.CommonUtils;

import java.util.Arrays;
import java.util.Random;

import static com.umwix1002.solution.lab.CommonConstant.ONE;
import static com.umwix1002.solution.lab.CommonConstant.ZERO;

/**
 * This class demonstrates different methods to transpose a square matrix.
 * It only works for square matrices; for non-square matrices, it throws an {@link IllegalArgumentException}.
 *
 * @author Ng Zhi Yang
 */
public class l5q4 {
    public static void main(String[] args) {
        int[][] matrix = getIntMatrix(4, 1, 9);
        printIntMatrix(matrix);
        
        int[][] transpose1 = transposeIntMatrixByLooping(matrix);
        printIntMatrix(transpose1);
        
        int[][] transpose2 = transposeIntMatrixByPattern(matrix);
        printIntMatrix(transpose2);
    }

    /**
     * Transposes a square matrix by swapping its elements along the diagonal.
     * This method modifies the copied matrix in place without changing the original.
     *
     * @param matrix the matrix to transpose
     * @return a new matrix that is the transposed version of the input matrix
     * @throws IllegalArgumentException if the matrix is not square
     */
    public static int[][] transposeIntMatrixByPattern(int[][] matrix) {
        CommonUtils.checkIfSquareMatrix(matrix);
        int[][] result = deepCopy(matrix);
        for (int row = ZERO; row < matrix.length; row++) {
            for (int col = row + ONE; col < matrix.length; col++) {
                int tmp = result[row][col];
                result[row][col] = result[col][row];
                result[col][row] = tmp;
            }
        }
        return result;
    }

    /**
     * Transposes a square matrix by looping through its elements.
     * This method creates a new matrix where the rows of the original become the columns.
     *
     * @param matrix the matrix to transpose
     * @return a new matrix that is the transposed version of the input matrix
     * @throws IllegalArgumentException if the matrix is not square
     */
    public static int[][] transposeIntMatrixByLooping(int[][] matrix) {
        CommonUtils.checkIfSquareMatrix(matrix);
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i = ZERO; i < result.length; i++) {
            for(int j = result.length - ONE; j >= ZERO; j--){
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    /**
     * Creates a deep copy of the provided 2D array (matrix).
     * This ensures that modifications to the copy do not affect the original array.
     *
     * @param src the matrix to copy
     * @return a new matrix that is a deep copy of the input matrix
     */
    public static int[][] deepCopy(int[][] src) {
        return Arrays.stream(src).map(int[]::clone).toArray(int[][]::new);
    }

    /**
     * Generates a square matrix of a specified size filled with random integers 
     * between the specified minimum (inclusive) and maximum (exclusive) values.
     *
     * @param size the number of rows and columns in the square matrix
     * @param min the minimum value for the random integers
     * @param max the maximum value for the random integers
     * @return a square matrix populated with random integers
     */
    public static int[][] getIntMatrix(int size, int min, int max) {
        int[][] matrix = new int[size][size];
        for(int i = ZERO; i < matrix.length; i++) {
            matrix[i] = new Random().ints(size, min, max).toArray();
        }
        return matrix;
    }

    /**
     * Prints the elements of a 2D array (matrix) to the console in a readable format.
     * Each row of the matrix is printed on a new line.
     *
     * @param matrix the matrix to print
     */
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
