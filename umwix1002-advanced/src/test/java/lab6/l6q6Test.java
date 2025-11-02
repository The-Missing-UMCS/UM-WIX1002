package lab6;

import com.umwix1002.solution.lab.lab06.l6q6b;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class l6q6Test {
    @ParameterizedTest
    @CsvSource({
        "2, true",
        "11, true",
        "121, false",
        "919, true",
        "10, false"
    })
    void testIsPalindromicPrime(int input, boolean expected) {
        assertEquals(expected, l6q6b.isPalindromicPrime(input));
    }

    @ParameterizedTest
    @CsvSource({
        "13, true",
        "17, true",
        "24, false",
        "751, true",
        "10, false"
    })
    void testIsEmirp(int input, boolean expected) {
        assertEquals(expected, l6q6b.isEmirp(input));
    }

    @ParameterizedTest
    @CsvSource({
        "2, true",
        "4, false",
        "11, true",
        "14, false",
        "13, true"
    })
    void testIsPrime(int input, boolean expected) {
        assertEquals(expected, l6q6b.isPrime(input));
    }

    @ParameterizedTest
    @CsvSource({
        "121, true",
        "123, false",
        "10, false",
        "0, true",
        "-121, false"
    })
    void testIsPalindromic(int input, boolean expected) {
        assertEquals(expected, l6q6b.isPalindromic(input));
    }

    @ParameterizedTest
    @CsvSource({
        "123, 321",
        "120, 21",
        "1, 1",
        "0, 0",
        "4456, 6544"
    })
    void testReverse(int input, int expected) {
        assertEquals(expected, l6q6b.reverse(input));
    }
}