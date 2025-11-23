package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q5.Q5B.model;

public record Player(String name, String gender, String age, Address address) {
    @Override
    public String toString() {
        return String.format("%s, %s years old", name, age);
    }
}
