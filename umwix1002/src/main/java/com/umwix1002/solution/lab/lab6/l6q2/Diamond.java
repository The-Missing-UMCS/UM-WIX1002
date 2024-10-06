package com.umwix1002.solution.lab.lab6.l6q2;

import static com.umwix1002.solution.lab.CommonConstant.ONE;
import static com.umwix1002.solution.lab.CommonConstant.TWO;

public class Diamond extends Shape {
    public Diamond(int size) {
        super(size);
    }

    @Override
    public boolean[][] initShapeArray() {
        return new boolean[getSize()][Math.ceilDiv(getSize(), TWO) * TWO];
    }
    
    @Override
    public boolean[][] getShapeArray() {
        int mid = getSize() / TWO;
        int count = -1;

        for(int i = 0; i < mid; i++) {
            int offset = mid - i;
            count = 0;
            for(int j = 0; count <= i; j += 2) {
                shapeArray[i][offset + j] = true;
                count++;
            }
        }
        count = 0;
        for(int j = 0; j < shapeArray[mid].length && count <= Math.ceilDiv(getSize(), TWO); j += 2) {
            shapeArray[mid][j] = true;
            count++;
        }
        for(int i = mid; i > 0; i--) {
            int offset = i - 1;
            for(int j = 0; j < i; j += 2) {
                shapeArray[i][offset + j] = true;
            }
        }
        return shapeArray;
    }
    

    
}
