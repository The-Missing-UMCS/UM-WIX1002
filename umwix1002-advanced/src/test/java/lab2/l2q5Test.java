package lab2;

import com.umwix1002.solution.lab.lab2.l2q5;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class l2q5Test {
    @Test
    public void testSumDigitsUsingFor() {
        int result = l2q5.sumDigitsUsingFor(12345);
        assertEquals(15, result);
    }
    
    @Test
    public void testSumDigitsUsingWhile() {
        int result = l2q5.sumDigitsUsingWhile(12345);
        assertEquals(15, result);
    }
}
