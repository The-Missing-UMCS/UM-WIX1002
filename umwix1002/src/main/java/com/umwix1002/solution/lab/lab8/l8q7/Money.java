package com.umwix1002.solution.lab.lab8.l8q7;

import com.umwix1002.solution.lab.CommonConstant;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
public class Money {
    private static final int[] NOTES = {100, 50, 10, 5, 1};
    private static final int[] COINS = {50, 20, 10, 5};

    private final int cent;
    private final double amount;

    @Getter(AccessLevel.PRIVATE)
    private int[] counts = new int[NOTES.length + COINS.length];

    Money(Double amount) {
        this.amount = amount;
        this.cent = round((int) (amount * 100));
    }

    private static int round(int value) {
        return ((value + 2) / 5 * 5);
    }

    public static Money subtract(double m1, double m2) {
        double value = m1 - m2;
        if (value < CommonConstant.ZERO) {
            throw new IllegalArgumentException("m1 must be greater than or equal m2");
        }
        return new Money(Math.abs(m1 - m2));
    }

    public static Money subtract(Money m1, Money m2) {
        return Money.subtract(m1.getAmount(), m2.getAmount());
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

    public String getNotesAndCoins() {
        return getNotesAndCoins(true, true);
    }

    public String getNotes() {
        return getNotesAndCoins(true, false);
    }

    public String getCoins() {
        return getNotesAndCoins(false, true);
    }

    public String getNotesAndCoins(boolean enableNotes, boolean enableCoins) {
        setupCounts();
        StringBuilder sb = new StringBuilder();
        if(enableNotes) {
            String notesOutput = IntStream.range(CommonConstant.ZERO, NOTES.length)
                .mapToObj(i -> String.format("%d x RM %d", counts[i], NOTES[i]))
                .collect(Collectors.joining(CommonConstant.LINE_BREAK));
            sb.append(notesOutput).append(CommonConstant.LINE_BREAK);
        }
        if(enableCoins) {
            String coinsOutput = IntStream.range(CommonConstant.ZERO, COINS.length)
                .mapToObj(i -> String.format("%d x %d cents", counts[NOTES.length + i], COINS[i]))
                .collect(Collectors.joining(CommonConstant.LINE_BREAK));
            sb.append(coinsOutput).append(CommonConstant.LINE_BREAK);
        }
        return sb.toString();
    }

    private void setupCounts() {
        int tmp = cent;
        
        for (int i = 0; i < NOTES.length; i++) {
            counts[i] = tmp / (NOTES[i] * 100);
            tmp %= (NOTES[i] * 100);
        }
        
        for (int i = 0; i < COINS.length; i++) {
            counts[NOTES.length + i] = tmp / COINS[i];
            tmp %= COINS[i];
        }
    }
}
