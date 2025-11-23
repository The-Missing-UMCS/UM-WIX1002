package com.umwix1002.solution.lab.lab09.l9q1.l9q2b;

public record Square(
    double side
) implements Shape {

    public static Square withSide(double side) {
        return new Square(side);
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }

    @Override
    public double area() {
        return side * side;
    }

    @Override
    public String shapeType() {
        return "Square";
    }
}
