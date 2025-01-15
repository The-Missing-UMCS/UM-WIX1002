package com.umwix1002.solution.lab.Lab8.L8Q5;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;
    private int points = 0;

    public void rollDice() {
        this.points += (int) (Math.random() * 6 + 1);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
