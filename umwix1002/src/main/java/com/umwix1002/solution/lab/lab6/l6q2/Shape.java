package com.umwix1002.solution.lab.lab6.l6q2;

import com.umwix1002.solution.lab.CommonConstant;
import com.umwix1002.solution.lab.CommonUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

import static com.umwix1002.solution.lab.CommonConstant.*;

/**
 * @author Ng Zhi Yang
 */
@Getter
@Setter
public abstract class Shape {
    private static final char TRUE_SYMBOL = '*';
    private static final char FALSE_SYMBOL = SPACE.charAt(ZERO);
    
    protected boolean[][] shape;
    private int size;
    
    protected Shape(int size) {
        this.size = size;
        this.shape = new boolean[size][size * TWO];
    }
    
    public static Triangle getInstance(int size) {
        return new Triangle(size);
    }
    
    public abstract boolean[][] getShape();
    
    public void display() {
        boolean[][] shape = getShape();
        int rowNum = shape.length;
        int colNum = shape[ZERO].length;
        for(int row = ZERO; row < rowNum; row++) {
            for(int col = ZERO; col < colNum - 1; col++) {
                System.out.print(shape[row][col] ? TRUE_SYMBOL : FALSE_SYMBOL);
            }
            System.out.println();
        }
    }
}
