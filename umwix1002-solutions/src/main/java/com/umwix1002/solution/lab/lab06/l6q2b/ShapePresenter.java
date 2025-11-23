package com.umwix1002.solution.lab.lab06.l6q2b;

public class ShapePresenter {
    private static final Character DEFAULT_TRUE_SYMBOL = '*';
    private static final Character DEFAULT_FALSE_SYMBOL = ' ';

    private final Character trueSymbol;
    private final Character falseSymbol;

    public ShapePresenter(Character trueSymbol, Character falseSymbol) {
        this.trueSymbol = trueSymbol;
        this.falseSymbol = falseSymbol;
    }

    public static ShapePresenter getInstance() {
        return new ShapePresenter(DEFAULT_TRUE_SYMBOL, DEFAULT_FALSE_SYMBOL);
    }

    public void display(Shape shape) {
        boolean[][] shapeArray = shape.getShapeArray();
        int colNum = shapeArray[0].length;
        for (boolean[] booleans : shapeArray) {
            for (int col = 0; col < colNum - 1; col++) {
                System.out.print(booleans[col] ? trueSymbol : falseSymbol);
            }
            System.out.println();
        }
    }
}
