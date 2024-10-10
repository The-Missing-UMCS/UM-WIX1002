package com.umwix1002.solution.lab.lab9.l9q1;

import com.umwix1002.solution.lab.CommonConstant;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class Rectangle extends Shape {
    private double width;
    private double height;

    Rectangle(double width, double height) {
        super(ShapeConstant.RECTANGLE);
        this.width = width;
        this.height = height;
        compute();
    }
    
    @Override
    protected void compute() {
        setArea(width * height);
        setPerimeter(CommonConstant.TWO * (width + height));
    } 
    
    public void setWidth(double width) {
        this.width = width;
        compute();
    }
    
    public void setHeight(double height) {
        this.height = height;
        compute();
    }
}
