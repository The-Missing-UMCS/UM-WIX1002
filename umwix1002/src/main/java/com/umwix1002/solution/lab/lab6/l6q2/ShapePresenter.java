package com.umwix1002.solution.lab.lab6.l6q2;

import lombok.Data;
import lombok.experimental.Accessors;

import static com.umwix1002.solution.lab.CommonConstant.ONE;
import static com.umwix1002.solution.lab.CommonConstant.ZERO;

@Data
@Accessors(chain = true)
public class ShapePresenter {
    private static final Character DEFAULT_TRUE_SYMBOL = '*';
    private static final Character DEFAULT_FALSE_SYMBOL = ' ';

    private Character trueSymbol;
    private Character falseSymbol;

    public static ShapePresenter getInstance() {
        return new ShapePresenter()
                .setTrueSymbol(DEFAULT_TRUE_SYMBOL)
                .setFalseSymbol(DEFAULT_FALSE_SYMBOL);
    }

    public void display(Shape shape) {
        boolean[][] shapeArray = shape.getShapeArray();
        int rowNum = shapeArray.length;
        int colNum = shapeArray[ZERO].length;
        for(int row = ZERO; row < rowNum; row++) {
            for(int col = ZERO; col < colNum - ONE; col++) {
                System.out.print(shapeArray[row][col] ? getTrueSymbol() : getFalseSymbol());
            }
            System.out.println();
        }
    }
}
