package com.umwix1002.solution.viva.viva2324.viva03.Q2;

public class Pokemon implements Comparable<Pokemon>{
    private String name;
    private String type;
    private double strength;

    Pokemon(String name, String type, double strength) {
        this.name = name;
        this.type = type;
        this.strength = strength;
    }

    @Override
    public int compareTo(Pokemon o) {
        return Double.compare(this.strength, o.strength);
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getStrength() {
        return strength;
    }

    public String toString() {
        return this.name;
    }
}
