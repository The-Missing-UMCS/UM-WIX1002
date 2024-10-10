package com.umwix1002.solution.lab.lab9.l9q1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4, 6);
        Square square = new Square(5);
        
        Shape[] shapes = {circle, rectangle, square};
        Arrays.stream(shapes).forEach(System.out::println);
        
        circle.setDiameter(10.0);
        rectangle.setWidth(8);
        rectangle.setHeight(10);
        square.setSide(7);
        Arrays.stream(shapes).forEach(System.out::println);
    }
}
