package com.umwix1002.solution.lab.lab09.l9q1.shape;

import com.umwix1002.solution.lab.lab09.l9q1.ShapeConstant;
import lombok.*;

/**
 * @author Ng Zhi Yang
 */

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Square implements Shape {
    private double side;

    /**
     * Create a square with a side
     * @param side the side of the square
     * @return the square
     */
    public static Square withSide(double side) {
        return new Square(side);
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public String getShapeType() {
        return ShapeConstant.SQUARE;
    }
}
