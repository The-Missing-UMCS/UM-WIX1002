package com.umwix1002.solution.lab.Lab9.L9Q4;

import java.util.Random;

public abstract class DiceGame {
    protected DicePlayer one;
    protected DicePlayer two;

    DiceGame(DicePlayer one, DicePlayer two) {
        this.one = one;
        this.two = two;
    }

    public void gamePlay() {
        boolean isOneTurn = new Random().nextBoolean();
        DicePlayer winner;
        while (true) {
            DicePlayer currentPlayer = isOneTurn ? one : two;
            notifyTakeTurn(currentPlayer);
            System.out.printf("%n%s's points = %d%n", currentPlayer, currentPlayer.getPoints());
            if((winner = findWinner()) != null) {
                break;
            }
            isOneTurn = !isOneTurn;
        }

        System.out.println(winner + "has won!");
    }

    abstract void notifyTakeTurn(DicePlayer player);

    abstract DicePlayer findWinner();
}