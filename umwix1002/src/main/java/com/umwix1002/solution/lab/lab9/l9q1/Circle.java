package com.umwix1002.solution.lab.lab9.l9q1;

import com.umwix1002.solution.lab.constants.CommonConstant;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Ng Zhi Yang
 */
@Getter
@ToString(callSuper = true)
public class Circle extends Shape {
    private double diameter;

    Circle(double diameter) {
        super(ShapeConstant.CIRCLE);
        this.diameter = diameter;
        compute();
    }
    
    @Override
    protected void compute() {
        setArea(Math.PI * Math.pow(diameter / CommonConstant.TWO, CommonConstant.TWO));
        setPerimeter(Math.PI * diameter);
    }
    
    public void setDiameter(double diameter) {
        this.diameter = diameter;
        compute();
    }
}
