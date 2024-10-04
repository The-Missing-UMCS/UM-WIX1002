package com.umwix1002.solution.lab.lab6.l6q2;

import static com.umwix1002.solution.lab.CommonConstant.*;

/**
 * @author Ng Zhi Yang
 */
public class Triangle extends Shape {
    public Triangle(int size) {
        super(size);
    }

    /**
     * Generates a triangular shape stored in a boolean 2D array.
     * The triangle is filled in such a way that each row contains 
     * a symbol (e.g. '*') represented by 'true' values, with another symbol 
     * (e.g. spaces) represented by 'false' values.
     * <p>
     * The triangle is visualized as follows for a size of 4:
     * <pre>
     *    *         <- row 0 (index 0)
     *   * *        <- row 1 (index 1)
     *  * * *       <- row 2 (index 2)
     * * * * *      <- row 3 (index 3)
     * </pre>
     * For each row, the number of 'true' values increases by 1 
     * as you move up the rows, and they are centered horizontally.
     *
     * @return a 2D boolean array representing the triangular shape.
     */
    @Override
    public boolean[][] getShape() {
        int rowNum = shape.length;
        int colNum = shape[0].length;
        
        for(int row = ONE; row <= rowNum; row++) {
            int offsetToCenterTriangle = rowNum - row;

            // Increment by TWO to account for spaces between each 'true' value.
            // Since row and col start at ONE, we subtract ONE for 0-based indexing.
            for(int col = ONE; col <= colNum; col += TWO) {
                boolean[] currentRow = shape[row - ONE];
                int index = col - ONE + offsetToCenterTriangle;
                currentRow[index] = true;
            }
        }
        return shape;
    }
}
