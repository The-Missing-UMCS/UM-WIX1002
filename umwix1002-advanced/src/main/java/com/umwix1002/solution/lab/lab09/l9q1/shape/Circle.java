package com.umwix1002.solution.lab.lab09.l9q1.shape;

import lombok.Getter;

import static com.umwix1002.solution.lab.constants.CommonConstant.TWO;


@Getter
public class Circle implements Shape {

    private double radius;

    private Circle(double radius) {
        this.radius = radius;
    }

    public static Circle withRadius(double radius) {
        return new Circle(radius);
    }

    public static Circle withDiameter(double diameter) {
        return new Circle(diameter / 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getDiameter() {
        return 2 * radius;
    }

    public void setDiameter(double diameter) {
        radius = diameter / 2;
    }

    @Override
    public String getShapeType() {
        return "CIRCLE";
    }
}
