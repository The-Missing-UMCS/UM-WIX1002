package com.umwix1002.solution.lab.lab9.l9q1.shape;

import com.umwix1002.solution.lab.constants.CommonConstant;
import com.umwix1002.solution.lab.lab9.l9q1.ShapeConstant;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Rectangle implements Shape {
    private double width;
    private double height;

    /**
     * Create a rectangle with a width and height
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @return the rectangle
     */
    public static Rectangle withWidthAndHeight(double width, double height) {
        return new Rectangle(width, height);
    }

    @Override
    public double getPerimeter() {
        return CommonConstant.TWO * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String getShapeType() {
        return ShapeConstant.RECTANGLE;
    }
}
