package com.umwix1002.solution.lab.lab6.l6q2;

import static com.umwix1002.solution.lab.CommonConstant.*;

/**
 * @author Ng Zhi Yang
 */
public class Triangle extends Shape {
    public Triangle(int size) {
        super(size);
    }

    @Override
    protected boolean[][] initShapeArray() {
        return new boolean[getSize()][getSize() * TWO];
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
    public boolean[][] getShapeArray() {
        int rowNum = getSize();
        
        for(int row = ZERO; row < rowNum; row++) {
            int col = rowNum - row - ONE;
            int count = ZERO;

            while(count <= row) {
                shapeArray[row][col] = true;
                col += TWO;
                count++;
            }
        }
        return shapeArray;
    }
}
