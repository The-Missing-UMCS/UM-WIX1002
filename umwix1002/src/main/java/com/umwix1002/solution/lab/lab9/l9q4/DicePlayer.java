package com.umwix1002.solution.lab.lab9.l9q4;

import lombok.Data;

/**
 * @author Ng Zhi Yang
 */
@Data
public class DicePlayer {
    protected String name;
    private int points;
    
    public DicePlayer(String name) {
        this.name = name;
    }

    public int rollDice() {
        int score = (int)(Math.random() * 6 + 1);
        this.points += score;
        return score;
    }
}
