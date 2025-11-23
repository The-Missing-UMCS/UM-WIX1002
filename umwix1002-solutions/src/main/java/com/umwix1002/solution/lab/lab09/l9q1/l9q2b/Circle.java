package com.umwix1002.solution.lab.lab09.l9q1.l9q2b;


public record Circle(
    double radius
) implements Shape {

    public static Circle withRadius(double radius) {
        return new Circle(radius);
    }

    public static Circle withDiameter(double diameter) {
        return new Circle(diameter / 2);
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    public double diameter() {
        return 2 * radius;
    }

    @Override
    public String shapeType() {
        return "Circle";
    }
}
