package com.umwix1002.solution.lab.lab09.l9q1;

import com.umwix1002.solution.lab.lab09.l9q1.shape.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Circle circle = Circle.withRadius(3);
        Rectangle rectangle = Rectangle.withWidthAndHeight(4, 6);
        Square square = Square.withSide(5);
        
        Shape[] shapes = {circle, rectangle, square};
        Arrays.stream(shapes).forEach(shape -> System.out.println(toString(shape)));
        
        circle.setDiameter(10.0);
        rectangle.setWidth(8);
        rectangle.setHeight(10);
        square.setSide(7);

        Arrays.stream(shapes).forEach(shape -> System.out.println(toString(shape)));
    }

    private static String toString(Shape shape) {
        return shape.getShapeType() + " Perimeter: " + shape.getPerimeter() + " Area: " + shape.getArea();
    }
}
