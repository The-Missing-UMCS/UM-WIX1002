package com.umwix1002.solution.lab.lab6.l6q2;

public class Main {
    public static void main(String[] args) {
        ShapePresenter shapePresenter = ShapePresenter.getInstance();

//        Shape triangle = ShapeFactory.getShape(ShapeFactory.TRIANGLE, 10);
//        shapePresenter.display(triangle);

        Shape diamond = ShapeFactory.getShape(ShapeFactory.DIAMOND, 5);
        shapePresenter.display(diamond);
    }
}
