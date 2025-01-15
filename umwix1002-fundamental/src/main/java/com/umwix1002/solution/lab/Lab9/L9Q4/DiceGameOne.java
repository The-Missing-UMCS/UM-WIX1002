package com.umwix1002.solution.lab.Lab9.L9Q4;

public class DiceGameOne extends DiceGame {

    DiceGameOne(DicePlayer one, DicePlayer two) {
        super(one, two);
    }

    @Override
    public void notifyTakeTurn(DicePlayer player) {
        if (player.rollDice() == player.rollDice()) {
            this.notifyTakeTurn(player);
        }
    }

    @Override
    protected DicePlayer findWinner() {
        if(one.getPoints() >= 100) {
            return one;
        } else if(two.getPoints() >= 100) {
            return two;
        }
        return null;
    }
}
