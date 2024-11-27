package com.umwix1002.solution.lab.lab9.l9q1.shape;

import com.umwix1002.solution.lab.constants.CommonConstant;
import com.umwix1002.solution.lab.lab9.l9q1.ShapeConstant;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Rectangle extends Shape {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        super(ShapeConstant.RECTANGLE);
        this.width = width;
        this.height = height;
    }
    
    @Override
    protected void compute() {
        setArea(width * height);
        setPerimeter(CommonConstant.TWO * (width + height));
    }
}
