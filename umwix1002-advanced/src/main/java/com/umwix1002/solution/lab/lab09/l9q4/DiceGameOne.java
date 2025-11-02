package com.umwix1002.solution.lab.lab09.l9q4;

/**
 * @author Ng Zhi Yang
 */
public class DiceGameOne extends DiceGame {
    public DiceGameOne(DicePlayer one, DicePlayer two) {
        super(one, two);
    }

    @Override
    public void notifyTakeTurn(DicePlayer player) {
        if (player.rollDice() == player.rollDice()) {
            this.notifyTakeTurn(player);
        }
    }

    @Override
    public boolean hasWon(DicePlayer player) {
        return player.getPoints() >= DEFAULT_TARGET_SCORE;
    }
}
