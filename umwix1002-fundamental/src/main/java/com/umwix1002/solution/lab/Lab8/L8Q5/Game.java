package com.umwix1002.solution.lab.Lab8.L8Q5;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Game {
    private Player one;
    private Player two;

    public void start() {
        boolean isOneTurn = new Random().nextBoolean();

        while (Math.max(one.getPoints(), two.getPoints()) < 100) {
            Player currentPlayer = isOneTurn ? one : two;
            currentPlayer.rollDice();
            isOneTurn = !isOneTurn;
        }

        System.out.println(one + "'s points = " + one.getPoints());
        System.out.println(two + "'s points = " + two.getPoints());
        System.out.println(((one.getPoints() >= 100) ? one : two) + " wins!");
    }
}
