package com.umwix1002.solution.lab.lab6.l6q2;

import lombok.*;

import static com.umwix1002.solution.lab.CommonConstant.*;

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
}
