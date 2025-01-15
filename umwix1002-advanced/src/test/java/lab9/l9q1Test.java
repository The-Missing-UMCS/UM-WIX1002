package lab9;

import com.umwix1002.solution.lab.lab9.l9q1.shape.Circle;
import com.umwix1002.solution.lab.lab9.l9q1.shape.Rectangle;
import com.umwix1002.solution.lab.lab9.l9q1.shape.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class l9q1Test {

    @DisplayName("Test Circle")
    @ParameterizedTest
    @CsvSource({
            "3, 18.85, 28.27",
            "4, 25.13, 50.27",
            "5, 31.42, 78.54"
    })
    public void testCircle(double radius, double perimeter, double area) {
        Circle circle = Circle.withRadius(radius);
        assertThat(circle.getPerimeter()).isCloseTo(perimeter, within(0.01));
        assertThat(circle.getArea()).isCloseTo(area, within(0.01));
    }

    @DisplayName("Test Rectangle")
    @ParameterizedTest
    @CsvSource({
            "3, 4, 14, 12",
            "5, 6, 22, 30",
            "7, 8, 30, 56"
    })
    public void testRectangle(double width, double length, double perimeter, double area) {
        Rectangle rectangle = Rectangle.withWidthAndHeight(width, length);
        assertThat(rectangle.getPerimeter()).isCloseTo(perimeter, within(0.01));
        assertThat(rectangle.getArea()).isCloseTo(area, within(0.01));
    }

    @DisplayName("Test Square")
    @ParameterizedTest
    @CsvSource({
            "3, 12, 9",
            "4, 16, 16",
            "5, 20, 25"
    })
    public void testSquare(double side, double perimeter, double area) {
        Square square = Square.withSide(side);
        assertThat(square.getPerimeter()).isCloseTo(perimeter, within(0.01));
        assertThat(square.getArea()).isCloseTo(area, within(0.01));
    }

}
