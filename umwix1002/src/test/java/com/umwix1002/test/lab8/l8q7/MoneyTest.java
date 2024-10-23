package com.umwix1002.test.lab8.l8q7;

import com.umwix1002.solution.lab.lab8.l8q7.Money;
import com.umwix1002.solution.lab.util.exception.NegativeValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    private Money money;

    @BeforeEach
    public void setUp() {
        money = new Money(123.45);
    }

    @Test
    public void testConstructorAndGetters() {
        assertEquals(123.45, money.getAmount());
        assertEquals(12345, money.getCent());
    }

    @Test
    public void testAddDouble() {
        Money result = money.add(10.55);
        assertEquals(134.00, result.getAmount());
    }

    @Test
    public void testAddMoney() {
        Money additional = new Money(5.55);
        Money result = money.add(additional);
        assertEquals(129.00, result.getAmount());
    }

    @Test
    public void testSubtractDouble() {
        Money result = money.subtract(23.45);
        assertEquals(100.00, result.getAmount());
    }

    @Test
    public void testSubtractMoney() {
        Money toSubtract = new Money(23.45);
        Money result = money.subtract(toSubtract);
        assertEquals(100.00, result.getAmount());
    }

    @Test
    public void testStaticSubtract() {
        Money result = Money.subtract(150.00, 50.00);
        assertEquals(100.00, result.getAmount());
    }

    @Test
    public void testGetNotes() {
        String notes = money.getNotes();
        assertTrue(notes.contains("1 x RM 100"));
        assertTrue(notes.contains("0 x RM 50"));
        assertTrue(notes.contains("2 x RM 10"));
        assertTrue(notes.contains("0 x RM 5"));
        assertTrue(notes.contains("3 x RM 1"));
    }

    @Test
    public void testGetCoins() {
        String coins = money.getCoins();
        assertTrue(coins.contains("0 x 50 cents"));
        assertTrue(coins.contains("2 x 20 cents"));
        assertTrue(coins.contains("0 x 10 cents"));
        assertTrue(coins.contains("1 x 5 cents"));
    }

    @Test
    public void testGetNotesAndCoins() {
        String notesAndCoins = money.getNotesAndCoins();
        assertTrue(notesAndCoins.contains("1 x RM 100"));
        assertTrue(notesAndCoins.contains("0 x 50 cents"));
    }

    @Test
    public void testSubtractNonNegative() {
        assertThatThrownBy(() -> Money.subtract(50.00, 100.00))
            .rootCause()
            .isInstanceOf(NegativeValueException.class)
            .hasMessage("m1 must be greater than or equal m2");
    }
}
