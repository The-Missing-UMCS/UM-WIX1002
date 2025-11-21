package com.umwix1002.solution.lab.lab06.l6q2b;

import lombok.*;

import static com.umwix1002.solution.lab.constants.CommonConstant.*;

/**
 * @author Ng Zhi Yang
 */
@NoArgsConstructor
public abstract class Shape {    
    @Setter(AccessLevel.NONE)
    protected boolean[][] shapeArray;

    @Getter
    private int size;
    
    protected Shape(int size) {
        init(size);
    }
    
    private void init(int size) {
        this.size = size;
        this.shapeArray = initShapeArray();
    }

    protected abstract boolean[][] initShapeArray();
    
    public abstract boolean[][] getShapeArray();

    public void setSize(int size) {
        init(size);
    }

    /**
     * Fills the specified row of the shapeArray, starting from the given column, 
     * by marking elements as filled based on the provided count.
     *
     * <p>
     * The filling begins at the starting column and occurs every {@code gap} columns 
     * until the target count is reached. For example, given the initial state:
     * </p>
     *
     * <pre>
     *     [ ][ ][ ][ ][ ][ ]
     *     startingCol = 0,
     *     targetCount = 3
     * </pre>
     *
     * <p>
     * The resulting state will be:
     * </p>
     *
     * <pre>
     *     [X][ ][X][ ][X][ ]
     * </pre>
     *
     * @param startingCol the index of the column to start filling (0-based)
     * @param targetCount the number of times to fill the array
     * @param row the row to fill (0-based)
     * @throws IndexOutOfBoundsException if startingCol or any calculated column is out of bounds during the filling process
     */
    protected void fill(int startingCol, int targetCount, int row) {
        int count = ZERO;
        for(int col = startingCol; count < targetCount; col += TWO) {
            shapeArray[row][col] = true;
            count++;
        }
    }
}
