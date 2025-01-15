package com.umwix1002.solution.lab.Lab8.L8Q7;

public class Money {
    private static final int[] NOTES = {100, 50, 10, 5, 1};
    private static final int[] COINS = {50, 20, 10, 5};
    private int[] counts = new int[NOTES.length + COINS.length];
    private final int valueCent;
    private final double valueCash;

    Money(Double amount) {
        this.valueCash = amount;
        this.valueCent = round((int) (amount * 100));
    }

    public int round(int value) {
        return ((value + 2) / 5 * 5);
    }

    public int getAmountAsCent() {
        return this.valueCent;
    }

    public double getAmountAsCash() {
        return this.valueCash;
    }

    /**
     * Takes two double values and return a Money object
     * @param value_one a double value representing cash value.
     * @param value_two a double value representing cash value.
     * @return a Money object
     */
    public static Money subtract(double value_one, double value_two) {
        return new Money(Math.abs(value_one - value_two));
    }

    public static Money subtract(Money one, Money two) {
        return Money.subtract(one.getAmountAsCash(), two.getAmountAsCash());
    }

    public Money subtract(double value) {
        return Money.subtract(this.getAmountAsCash(), value);
    }

    public Money subtract(Money money) {
        return Money.subtract(this, money);
    }


    // Class method add
    public static Money add(double value_one, double value_two) {
        return new Money(value_one + value_two);
    }

    public static Money add(Money one, Money two) {
        return Money.add(one.getAmountAsCash(), two.getAmountAsCash());
    }

    public Money add(double value) {
        return Money.add(this.getAmountAsCash(), value);
    }

    public Money add(Money money) {
        return Money.add(this, money);
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
        int tmp = valueCent;

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < NOTES.length; i++) {
            if(enableNotes) {
                counts[i] = tmp / (NOTES[i] * 100);
                sb.append(counts[i]).append(" x RM ").append(NOTES[i]).append("\n");
            }
            tmp %= (NOTES[i] * 100);
        }

        if (enableCoins) {
            for(int i = 0; i < COINS.length; i++) {
                counts[NOTES.length + i] = tmp / COINS[i];
                sb.append(counts[NOTES.length + i]).append(" x ").append(COINS[i]).append(" cents\n");
                tmp %= COINS[i];
            }
        }

        return sb.toString();
    }
}
