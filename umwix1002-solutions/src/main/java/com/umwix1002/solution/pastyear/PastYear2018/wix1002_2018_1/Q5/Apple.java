package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_1.Q5;

public class Apple extends Fruit {
    private static final String NAME = "APPLE";
    public static final String GREEN = "GREEN";
    public static final String RED = "RED";

    int quantity;

    public Apple(String type, int quantity) {
        super(Apple.NAME, type);
        this.quantity = quantity;
    }

    @Override
    public double totalPrice() {
        return quantity * getSinglePrice();
    }

    private double getSinglePrice() {
        return GREEN.equals(type) ? 1.2 : 1.8;
    }

    @Override
    public String toString() {
        return String.format("%s - %d = RM%.2f", super.toString(), quantity, totalPrice());
    }
}
