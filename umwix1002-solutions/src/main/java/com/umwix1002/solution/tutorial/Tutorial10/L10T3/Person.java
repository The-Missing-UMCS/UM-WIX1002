package com.umwix1002.solution.tutorial.Tutorial10.L10T3;

public record Person(String name) implements Comparable<Person> {
    @Override
    public int compareTo(Person another) {
        return (this.name().compareTo(another.name()));
    }

    @Override
    public String toString() {
        return this.name;
    }
}
