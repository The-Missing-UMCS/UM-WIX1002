package lab6;

import com.umwix1002.solution.lab.lab06.l6q5;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class l6q5Test {
    @Nested
    class ReverseTest {
        @ParameterizedTest
        @CsvSource({"2,4,8", "3,-3,-9", "5,-2,-10"})
        void checkTrue(int x, int y, int z) {
            assertTrue(l6q5.check(x, y, z));
        }

        @ParameterizedTest
        @CsvSource({"2,4,7", "3,-3,9", "5,-2,10"})
        void checkFalse(int x, int y, int z) {
            assertFalse(l6q5.check(x, y, z));
        }
    }
}