package com.umwix1002.solution.lab.lab9.l9q4;

/**
 * @author Ng Zhi Yang
 */
public class DiceGameTwo extends DiceGame {
    DiceGameTwo(DicePlayer one, DicePlayer two) {
        super(one, two);
    }

    @Override
    public void notifyTakeTurn(DicePlayer player) {
        int tmp = player.getPoints();

        if (player.rollDice() == DEFAULT_DICE_SIDES && player.rollDice() == DEFAULT_DICE_SIDES) {
            player.setPoints(tmp);
        }

        if (player.getPoints() > DEFAULT_TARGET_SCORE) {
            player.setPoints(tmp);
        }
    }

    @Override
    public boolean hasWon(DicePlayer player) {
        return player.getPoints() == DEFAULT_TARGET_SCORE;
    }


}
