package com.umwix1002.solution.lab.Lab7.L7Q5;

public record Person(String name, int age, char gender) implements Comparable<Person> {
    @Override
    public int compareTo(Person another) {
        return this.name().compareTo(another.name());
    }
}