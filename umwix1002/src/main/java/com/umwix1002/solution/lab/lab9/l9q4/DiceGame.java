package com.umwix1002.solution.lab.lab9.l9q4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class DiceGame {
    protected static final int DEFAULT_TARGET_SCORE = 100;
    protected static final int DEFAULT_DICE_SIDES = 6;
    
    protected DicePlayer one;
    protected DicePlayer two;
    
    abstract void notifyTakeTurn(DicePlayer player);
    abstract void gamePlay();
}
