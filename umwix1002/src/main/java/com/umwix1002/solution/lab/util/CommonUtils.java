package com.umwix1002.solution.lab.util;

import static com.umwix1002.solution.lab.CommonConstant.ZERO;

/**
 * @author Ng Zhi Yang
 */
public class CommonUtils {
    public static void checkIfSquareMatrix(int[][] matrix) {
        for (int row = ZERO; row < matrix.length; row++) {
            if (matrix[row].length != matrix.length) {
                throw new IllegalArgumentException("Matrix is not a square matrix");
            }
        }
    }
    
    public static void checkPositiveInteger(int value) {
        if (value <= ZERO) {
            throw new IllegalArgumentException("Value must be positive integer");
        }
    }
}
