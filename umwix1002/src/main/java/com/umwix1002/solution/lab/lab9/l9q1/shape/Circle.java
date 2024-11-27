package com.umwix1002.solution.lab.lab9.l9q1.shape;

import com.umwix1002.solution.lab.constants.CommonConstant;
import com.umwix1002.solution.lab.lab9.l9q1.ShapeConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Ng Zhi Yang
 */
@Getter
@Setter
@ToString(callSuper = true)
public class Circle extends Shape {
    private double diameter;

    Circle(double diameter) {
        super(ShapeConstant.CIRCLE);
        this.diameter = diameter;
    }
    
    @Override
    protected void compute() {
        setArea(Math.PI * Math.pow(diameter / CommonConstant.TWO, CommonConstant.TWO));
        setPerimeter(Math.PI * diameter);
    }
}
