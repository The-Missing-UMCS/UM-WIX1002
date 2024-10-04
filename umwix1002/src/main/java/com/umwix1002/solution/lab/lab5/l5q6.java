package com.umwix1002.solution.lab.lab5;

import com.umwix1002.solution.lab.CommonUtils;

import static com.umwix1002.solution.lab.CommonConstant.ONE;
import static com.umwix1002.solution.lab.CommonConstant.ZERO;

/**
 * @author Ng Zhi Yang
 */
public class l5q6 {
    public static void main(String[] args) {
        final int numberOfRows = 5;
        int[][] pascalTriangle = getPascalTriangle(numberOfRows);
        printPascalTriangle(pascalTriangle);
    }
    
    public static int[][] getPascalTriangle(int numberOfRows) {
        int[][] pascal = new int[numberOfRows][numberOfRows];
        for (int row = ZERO; row < numberOfRows; row++) {
            for (int col = ZERO; col <= row; col++) {
                boolean atEitherEnd = col == ZERO || col == row;
                if (atEitherEnd) {
                    pascal[row][col] = ONE;
                } else {
                    int[] prevRow = pascal[row - ONE];                    
                    pascal[row][col] = prevRow[col - ONE] + prevRow[col]; 
                }
            }
        }
        return pascal;
    }
    
    public static void printPascalTriangle(int[][] pascalTriangle) {
        CommonUtils.checkIfSquareMatrix(pascalTriangle);
        int numberOfRows = pascalTriangle.length;
        for (int row = ZERO; row < numberOfRows; row++) {
            for (int col = ZERO; col < numberOfRows; col++) {
                System.out.printf("%4d", pascalTriangle[row][col]); 
            }
            System.out.println();
        }
    }
}
