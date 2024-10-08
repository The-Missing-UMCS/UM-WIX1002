package com.umwix1002.solution.lab.lab6.l6q2;

import static com.umwix1002.solution.lab.CommonConstant.*;

public class Diamond extends Shape {
    public Diamond(int size) {
        super(size);
        checkIfValidDiamond(size);
    }

    @Override
    public boolean[][] initShapeArray() {
        return new boolean[getSize()][Math.ceilDiv(getSize(), TWO) * TWO];
    }
    
    @Override
    public boolean[][] getShapeArray() {
        int mid = getSize() / TWO;

        for(int row = ZERO; row < mid; row++) {
            fill(mid - row, row + ONE, row);
        }
        
        fill(ZERO, Math.ceilDiv(getSize(), TWO), mid);
        
        for(int row = mid + ONE; row < shapeArray.length; row++) {
            fill(row - Math.floorDiv(getSize(), TWO), getSize() - row, row);
        }
        
        return shapeArray;
    }

    private static void checkIfValidDiamond(int size) {
        if (!(size >= 3 && size % TWO == ONE)) {
            throw new IllegalArgumentException("Size must be odd and greater than or equal to 3");
        }
    }

    
}
