package com.umwix1002.solution.lab.lab6.l6q2;

import static com.umwix1002.solution.lab.CommonConstant.ONE;
import static com.umwix1002.solution.lab.CommonConstant.TWO;

public class ShapeFactory {
    public static final String TRIANGLE = "TRIANGLE";
    public static final String DIAMOND = "DIAMOND";

    public static Shape getShape(String shapeType, int size) {
        return switch (shapeType) {
            case TRIANGLE -> new Triangle(size);
            case DIAMOND -> {
                checkIfValidDiamond(size);
                yield new Diamond(size);
            }
            default -> throw new IllegalArgumentException("Invalid shape type");
        };
    }

    private static void checkIfValidDiamond(int size) {
        if (!(size >= 3 && size % TWO == ONE)) {
            throw new IllegalArgumentException("Size must be odd and greater than or equal to 3");
        }
    }
}
