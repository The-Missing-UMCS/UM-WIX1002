package com.umwix1002.solution.lab.lab8.l8q7;

import com.umwix1002.solution.lab.util.AssertUtil;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.umwix1002.solution.lab.constants.CommonConstant.*;

/**
 * @author Ng Zhi Yang
 */
@Data
public class Money {
    private static final int[] NOTES = {100, 50, 10, 5, 1};
    private static final int[] COINS = {50, 20, 10, 5};

    private final int cent;
    private final double amount;
    
    // To enhance the performance
    private boolean isSetup;

    @Getter(AccessLevel.PRIVATE)
    private int[] counts = new int[NOTES.length + COINS.length];

    public Money(Double amount) {
        this.amount = amount;
        this.cent = round((int) (amount * HUNDRED));
        this.isSetup = false;
    }

    private static int round(int value) {
        return ((value + TWO) / 5 * 5);
    }

    public static Money subtract(double m1, double m2) {
        AssertUtil.assertNonNegative(m1 - m2, "m1 must be greater than or equal m2");
        return new Money(Math.abs(m1 - m2));
    }

    public static Money subtract(Money m1, Money m2) {
        return subtract(m1.getAmount(), m2.getAmount());
    }

    public static Money add(double m1, double m2) {
        return new Money(m1 + m2);
    }

    public static Money add(Money m1, Money m2) {
        return Money.add(m1.getAmount(), m2.getAmount());
    }

    public Money subtract(double value) {
        return subtract(this.getAmount(), value);
    }

    public Money subtract(Money money) {
        return subtract(this, money);
    }

    public Money add(double value) {
        return add(this.getAmount(), value);
    }

    public Money add(Money money) {
        return add(this, money);
    }

    public String getNotes() {
        return getNoteString();
    }

    public String getCoins() {
        return getCoinString();
    }

    public String getNotesAndCoins() {
        return getNoteString() + getCoinString();
    }

    private String getNoteString() {
        return toMoneyString("%d x RM %d", NOTES, ZERO);
    }

    private String getCoinString() {
        return toMoneyString("%d x %d cents", COINS, NOTES.length);
    }

    private String toMoneyString(String format, int[] array, int offset) {
        setupCounts();
        StringBuilder sb = new StringBuilder();
        String output = IntStream.range(ZERO, array.length)
            .mapToObj(i -> String.format(format, counts[offset + i], array[i]))
            .collect(Collectors.joining(LINE_BREAK));
        return sb.append(output).append(LINE_BREAK).toString();
    }

    private void setupCounts() {
        if(isSetup) {
            return ;
        }
        int tmp = cent;

        for (int i = ZERO; i < NOTES.length; i++) {
            counts[i] = tmp / (NOTES[i] * HUNDRED);
            tmp %= (NOTES[i] * HUNDRED);
        }

        for (int i = ZERO; i < COINS.length; i++) {
            counts[NOTES.length + i] = tmp / COINS[i];
            tmp %= COINS[i];
        }
        isSetup = true;
    }
}
