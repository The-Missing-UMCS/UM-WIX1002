package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_1.Q5;

public abstract class Fruit {
    String name;
    String type;

    public Fruit(String name, String type) {
        this.name = name;
        this.type = type;
    }

    abstract double totalPrice();

    @Override
    public String toString() {
        return String.format("%s %s", type, name);
    }

}
