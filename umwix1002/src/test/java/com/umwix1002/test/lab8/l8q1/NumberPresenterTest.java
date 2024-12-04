package com.umwix1002.test.lab8.l8q1;

import com.umwix1002.solution.lab.lab8.l8q1.NumberPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class NumberPresenterTest {
    private NumberPresenter numberPresenter;

    @BeforeEach
    public void setUp() {
        // Initialize with a sample Number instance
        int[] numbers = {1, 4, 9, 16, 2, 3, 5, 7, 8, 10};
        numberPresenter = new NumberPresenter(numbers);
    }

    @Test
    public void testGetMax() {
        OptionalInt max = numberPresenter.getMax();
        assertTrue(max.isPresent());
        assertEquals(16, max.getAsInt());
    }

    @Test
    public void testGetMin() {
        OptionalInt min = numberPresenter.getMin();
        assertTrue(min.isPresent());
        assertEquals(1, min.getAsInt());
    }

    @Test
    public void testGetAverage() {
        OptionalDouble average = numberPresenter.getAverage();
        assertTrue(average.isPresent());
        assertEquals(6.5, average.getAsDouble(), 0.01);
    }

    @Test
    public void testGetPrime() {
        int[] primes = numberPresenter.getPrime();
        assertArrayEquals(new int[]{2, 3, 5, 7}, primes);
    }

    @Test
    public void testGetOdd() {
        int[] odds = numberPresenter.getOdd();
        assertArrayEquals(new int[]{1, 9, 3, 5, 7}, odds);
    }

    @Test
    public void testGetEven() {
        int[] evens = numberPresenter.getEven();
        assertArrayEquals(new int[]{4, 16, 2, 8, 10}, evens);
    }

    @Test
    public void testGetSquare() {
        int[] squares = numberPresenter.getSquare();
        assertArrayEquals(new int[]{1, 16, 81, 256, 4, 9, 25, 49, 64, 100}, squares);
    }

    @Test
    public void testGetPerfectSquare() {
        int[] perfectSquares = numberPresenter.getPerfectSquare();
        assertArrayEquals(new int[]{1, 4, 9, 16}, perfectSquares);
    }
}