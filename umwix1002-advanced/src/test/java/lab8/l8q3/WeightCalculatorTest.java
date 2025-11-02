package lab8.l8q3;

import com.umwix1002.solution.lab.lab08.l8q4.Fraction;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class WeightCalculatorTest {

    @ParameterizedTest
    @CsvSource({
        "48, 18, 6",
        "54, 24, 6",
        "101, 10, 1"
    })
    void testGetGCD(int numerator, int denominator, int expectedGCD) {
        Fraction fraction = new Fraction(numerator, denominator);
        assertEquals(expectedGCD, fraction.getGCD());
    }

    @ParameterizedTest
    @CsvSource({
        "8, 12, 2/3",
        "50, 100, 1/2",
        "7, 9, 7/9"
    })
    void testReduce(int numerator, int denominator, String expectedReduction) {
        Fraction fraction = new Fraction(numerator, denominator);
        assertEquals(expectedReduction, fraction.reduce());
    }

    @ParameterizedTest
    @CsvSource({
        "3, 4, 3/4",
        "5, 10, 5/10",
        "-1, 2, -1/2"
    })
    void testToString(int numerator, int denominator, String expectedString) {
        Fraction fraction = new Fraction(numerator, denominator);
        assertEquals(expectedString, fraction.toString());
    }
}
