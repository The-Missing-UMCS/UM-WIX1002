package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_1.Main;

public class Watermelon extends Fruit {
    private double weight;

    public Watermelon(String name, String type, double weight) {
        super(name, type);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    double totalPrice() {
        double pricePerKilogram = -1;
        if("LOCAL".equals(getType())) {
            if(weight < 2) {
                pricePerKilogram = 2.25;
            } else if (weight < 5) {
                pricePerKilogram = 1.95;
            } else {
                pricePerKilogram = 1.65;
            }
        } else {
            if(weight < 2) {
                pricePerKilogram = 3.75;
            } else if (weight < 5) {
                pricePerKilogram = 3.45;
            } else {
                pricePerKilogram = 3.15;
            }
        }
        return pricePerKilogram * weight;
    }

    @Override
    public String toString() {
        return super.toString() + " " + weight + " " + totalPrice();
    }
}
