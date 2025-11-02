package lab6;

import com.umwix1002.solution.lab.lab06.l6q1c;
import com.umwix1002.solution.lab.util.exception.NegativeValueException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class l6q1Test {
    
    @Nested
    class TriangularTest {
        @ParameterizedTest
        @CsvSource({"3,6", "1,1", "9,45"})
        void testTriangularNormal(int val, int expected) {
            assertEquals(expected, l6q1c.triangular(val));
        }

        @ParameterizedTest
        @CsvSource({"0", "-6", "-10"})
        void testTriangularThrowErrors(int val) {
            assertThatThrownBy(() -> l6q1c.triangular(val))
                .isInstanceOf(NegativeValueException.class);
        }
    }
}