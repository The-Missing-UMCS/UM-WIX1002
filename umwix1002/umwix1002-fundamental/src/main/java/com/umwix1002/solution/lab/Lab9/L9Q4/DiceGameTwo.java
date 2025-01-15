package com.umwix1002.solution.lab.Lab9.L9Q4A;

public class DiceGameTwo extends DiceGame {
    DiceGameTwo(DicePlayer one, DicePlayer two) {
        super(one, two);
    }

    @Override
    public void notifyTakeTurn(DicePlayer player) {
        int tmp = player.getPoints();

        if (player.rollDice() == 6) {
            if (player.rollDice() == 6) {
                player.setPoints(tmp);
            }
        }

        if (player.getPoints() > 100) {
            player.setPoints(tmp);
        }
    }

    @Override
    protected DicePlayer findWinner() {
        if(one.getPoints() == 100) {
            return one;
        } else if(two.getPoints() == 100) {
            return two;
        }
        return null;
    }
}