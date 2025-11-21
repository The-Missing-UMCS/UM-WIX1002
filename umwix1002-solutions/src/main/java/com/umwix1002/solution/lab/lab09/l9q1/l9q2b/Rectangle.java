package com.umwix1002.solution.lab.lab09.l9q1.l9q2b;

public record Rectangle(
    double width,
    double height
) implements Shape {

    public static Rectangle withWidthAndHeight(double width, double height) {
        return new Rectangle(width, height);
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String shapeType() {
        return "Rectangle";
    }
}
