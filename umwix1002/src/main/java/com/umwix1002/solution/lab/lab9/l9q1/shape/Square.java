package com.umwix1002.solution.lab.lab9.l9q1.shape;

import com.umwix1002.solution.lab.lab9.l9q1.ShapeConstant;
import lombok.*;

/**
 * @author Ng Zhi Yang
 */

@Getter
@Setter
@ToString(callSuper = true)
public class Square extends Shape {
    private double side;
    
    Square(double side) {
        super(ShapeConstant.SQUARE);
        this.side = side;
    }
    
    @Override
    protected void compute() {
        setArea(side * side);
        setPerimeter(4 * side);
    }
}
