package com.umwix1002.solution.lab.lab09.l9q1.l9q1a;

public class Square extends Shape {

    private double side;

    Square(double side) {
        super("Square");
        this.side = side;
        computeAreaAndPerimeter();
    }

    @Override
    public void computeAreaAndPerimeter() {
        this.area = side * 2;
        this.perimeter = 4 * side;
    }

    public void setSide(double side) {
        this.side = side;
        computeAreaAndPerimeter();
    }
}
