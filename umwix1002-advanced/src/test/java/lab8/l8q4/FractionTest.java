package lab8.l8q4;

import com.umwix1002.solution.lab.lab8.l8q4.Fraction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {
    private Fraction fraction;
    
    @Test
    public void testGetGCD() {
        fraction = new Fraction(48, 18);
        assertEquals(6, fraction.getGCD());

        fraction = new Fraction(54, 24);
        assertEquals(6, fraction.getGCD());

        fraction = new Fraction(101, 10);
        assertEquals(1, fraction.getGCD()); // No common factors
    }

    @Test
    public void testReduce() {
        fraction = new Fraction(8, 12);
        assertEquals("2/3", fraction.reduce()); // Reduced form

        fraction = new Fraction(50, 100);
        assertEquals("1/2", fraction.reduce()); // Reduced form

        fraction = new Fraction(7, 9);
        assertEquals("7/9", fraction.reduce()); // Already in simplest form
    }

    @Test
    public void testToString() {
        fraction = new Fraction(3, 4);
        assertEquals("3/4", fraction.toString());

        fraction = new Fraction(5, 10);
        assertEquals("5/10", fraction.toString());

        fraction = new Fraction(-1, 2);
        assertEquals("-1/2", fraction.toString()); // Negative numerator
    }

}