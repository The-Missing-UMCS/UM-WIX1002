package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_1.Main;

public class Apple extends Fruit {
    private int quantity;

    public Apple(String name, String type, int quantity) {
        super(name, type);
        this.quantity = quantity;
    }

    @Override
    public double totalPrice() {
        return ("GREEN".equals(getType()) ? 1.2 : 1.8) * quantity;
    }

    @Override
    public String toString() {
        return super.toString() + " " + quantity + " " + totalPrice();
    }
}
