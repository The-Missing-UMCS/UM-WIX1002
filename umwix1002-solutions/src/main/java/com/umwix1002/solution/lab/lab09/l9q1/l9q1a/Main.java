package com.umwix1002.solution.lab.lab09.l9q1.l9q1a;

public class Main {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{
            new Rectangle(4, 5),
            new Square(7),
            new Circle(14)
        };

        for (Shape shape : shapes) {
            shape.computeAreaAndPerimeter();
            shape.showDetails();
        }

        System.out.println();

        ((Rectangle) shapes[0]).setLengthAndHeight(3, 10);
        ((Square) shapes[1]).setSide(3);
        ((Circle) shapes[2]).setDiameter(21);

        for (Shape shape : shapes) {
            shape.computeAreaAndPerimeter();
            shape.showDetails();
        }
    }
}







