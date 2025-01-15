package com.umwix1002.solution.lab.lab3.l3q4.advanced;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        new DiceSystem(List.of(new Player("1"), new Player("2"), new Player("3"))).play();
    }
}
