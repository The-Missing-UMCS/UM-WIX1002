package com.umwix1002.solution.lab.Lab9.L9Q4A;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
public class DicePlayer {
    protected final String name;

    @Setter
    @Getter
    private int points;

    public int rollDice() {
        int score = (int) (Math.random() * 6 + 1);
        this.points += score;
        System.out.printf("%s rolled %d ", name, score);
        return score;
    }

    public String toString() {
        return name;
    }
}
