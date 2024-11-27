package com.umwix1002.solution.lab.lab9.l9q1;

import com.umwix1002.solution.lab.lab9.l9q1.shape.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Circle circle = ShapeBuilders.circle(5.0);
        Rectangle rectangle = ShapeBuilders.rectangle(4, 6);
        Square square = ShapeBuilders.square(5);
        
        Shape[] shapes = {circle, rectangle, square};
        Arrays.stream(shapes).forEach(System.out::println);
        
        circle.setDiameter(10.0);
        rectangle.setWidth(8);
        rectangle.setHeight(10);
        square.setSide(7);

        Arrays.stream(shapes).forEach(System.out::println);
    }
}
