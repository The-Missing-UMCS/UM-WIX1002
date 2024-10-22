package com.umwix1002.test.lab6;

import com.umwix1002.solution.lab.lab6.l6q4;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class l6q4Test {
    @ParameterizedTest
    @CsvSource({"24,8,8", "36,16,4", "272,148,4"})
    void testReverse(int a, int b, int expected) {
        assertEquals(expected, l6q4.findGCD(a, b));
    }
}