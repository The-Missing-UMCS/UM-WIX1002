package com.umwix1002.solution.lab.lab3.l3q4.advanced;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @author Ng Zhi Yang
 */
@Data
@RequiredArgsConstructor
public class Player {
    private final String id;
    private int score;

    public Integer rollDice() {
        score = (int) (Math.random() * 6 + 1);
        return score;
    }
}
