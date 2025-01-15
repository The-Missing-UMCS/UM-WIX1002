package com.umwix1002.solution.lab.lab3.l3q4.advanced;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class Player implements DicePlayable {
    private String id;
    
    @Override
    public Integer rollDice() {
        return (int) (Math.random() * 6 + 1);
    }
}
