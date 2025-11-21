package com.umwix1002.solution.lab.lab09.l9q1.l9q2b;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // 1. Initial shape properties
        Shape[] shapes = {
            Circle.withRadius(3),
            Rectangle.withWidthAndHeight(4, 6),
            Square.withSide(5)
        };

        Arrays.stream(shapes).forEach(shape -> System.out.println(toString(shape)));

        System.out.println();

        // 2. After update the shape properties
        shapes[0] = Circle.withDiameter(10.0);
        shapes[1] = Rectangle.withWidthAndHeight(8, 10);
        shapes[2] = Square.withSide(5);

        Arrays.stream(shapes).forEach(shape -> System.out.println(toString(shape)));
    }

    private static String toString(Shape shape) {
        return String.format(" %-10s : Perimeter: %-5.2f, Area: %-5.2f",
            shape.shapeType(), shape.perimeter(), shape.area());
    }

}
