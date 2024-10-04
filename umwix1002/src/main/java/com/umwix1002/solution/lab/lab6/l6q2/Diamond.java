package com.umwix1002.solution.lab.lab6.l6q2;

import com.umwix1002.solution.lab.CommonConstant;
import lombok.NoArgsConstructor;

public class Diamond extends Shape {
    private Diamond(int size) {
        super(size);
    }
    
    public static Diamond createDiamond(int size) {
        checkIfValidDiamond(size);
        return new Diamond(size);
    }
    
    @Override
    public boolean[][] getShape() {
        int mid = getSize() / CommonConstant.TWO;
        for(int i = 0; i < mid; i++) {
            int offset = mid - i;
        }
    }
    
    private static void checkIfValidDiamond(int size) {
        if (size >= 3 && size % 2 == 1) {
            throw new IllegalArgumentException("Size must be odd and greater than or equal to 3");
        }
    }
    
}
