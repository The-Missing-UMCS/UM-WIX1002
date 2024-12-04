package com.umwix1002.solution.lab.lab9.l9q1.shape;

import com.umwix1002.solution.lab.constants.CommonConstant;
import com.umwix1002.solution.lab.lab9.l9q1.ShapeConstant;
import lombok.*;

import static com.umwix1002.solution.lab.constants.CommonConstant.TWO;

/**
 * @author Ng Zhi Yang
 */
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Circle implements Shape {
    private double radius;

    /**
     * Create a circle with a radius
     * @param radius the radius of the circle
     * @return the circle
     */
    public static Circle withRadius(double radius) {
        return new Circle(radius);
    }

    /**
     * Create a circle with a diameter
     * @param diameter the diameter of the circle
     * @return the circle
     */
    public static Circle withDiameter(double diameter) {
        return new Circle(diameter / TWO);
    }

    @Override
    public double getPerimeter() {
        return TWO * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getDiameter() {
        return TWO * radius;
    }

    public void setDiameter(double diameter) {
        radius = diameter / TWO;
    }

    @Override
    public String getShapeType() {
        return ShapeConstant.CIRCLE;
    }
}
