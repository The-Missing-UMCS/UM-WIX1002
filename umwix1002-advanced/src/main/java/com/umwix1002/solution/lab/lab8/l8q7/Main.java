package com.umwix1002.solution.lab.lab8.l8q7;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    public static void main(String[] args) {
        Money money = new Money(123.47);
        System.out.println(money.getNotesAndCoins());
        System.out.println(money.getNotes());
        System.out.println(money.getCoins());
    }
}
