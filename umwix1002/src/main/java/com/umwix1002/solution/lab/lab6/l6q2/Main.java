package com.umwix1002.solution.lab.lab6.l6q2;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    public static void main(String[] args) {
        ShapePresenter shapePresenter = ShapePresenter.getInstance();
        shapePresenter.display(new Triangle(3));
        shapePresenter.display(new Diamond(5));
    }
}
