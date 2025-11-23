package lab6;

import com.umwix1002.solution.lab.lab06.l6q1c;
import com.umwix1002.solution.lab.lab06.l6q3b;
import com.umwix1002.solution.lab.util.exception.NegativeValueException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class l6q3Test {

    @Nested
    class ReverseTest {
        @ParameterizedTest
        @CsvSource({"3142,2413", "232,232", "4567,7654"})
        void testReverse(int val, int expected) {
            assertEquals(expected, l6q3b.reverse(val));
        }

        @ParameterizedTest
        @CsvSource({"-8", "-6", "-10"})
        void testReverseThrowError(int val) {
            assertThatThrownBy(() -> l6q1c.triangular(val))
                .isInstanceOf(NegativeValueException.class);
        }
    }
}