package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q5.model;

public class Player {
    final String name;
    final Integer age;
    final String address;

    public Player(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s, %d years old", name, age);
    }
}
