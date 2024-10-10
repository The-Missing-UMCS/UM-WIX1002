package com.umwix1002.solution.lab.lab9.l9q1;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Ng Zhi Yang
 */
@Getter
@ToString(callSuper = true)
public class Square extends Shape {
    private double side;
    
    Square(double side) {
        super(ShapeConstant.SQUARE);
        this.side = side;
        compute();
    }
    
    @Override
    protected void compute() {
        setArea(side * side);
        setPerimeter(4 * side);
    }
    
    public void setSide(int side) {
        this.side = side;
        compute();
    }
}
