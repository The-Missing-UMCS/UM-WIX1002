package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_1.Main;

public abstract class Fruit {
    private String name;
    private String type;

    public Fruit(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    abstract double totalPrice();

    @Override
    public String toString() {
        return name + " " + type;
    }
}
