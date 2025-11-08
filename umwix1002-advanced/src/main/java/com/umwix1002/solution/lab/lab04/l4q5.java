package com.umwix1002.solution.lab.lab04;

/**
 * @author Ng Zhi Yang
 */
public class l4q5 {

    public static void main(String[] args) {
        int p1 = 0, p2 = 0, dice, currentPlayer;
        boolean isOneTurn = true;
        while (Math.max(p1, p2) <= 20) {
            dice = (int) (Math.random() * 6 + 1);
            currentPlayer = isOneTurn ? 1 : 2;
            if (isOneTurn) {
                p1 += dice;
                isOneTurn = dice == 6;
            } else {
                p2 += dice;
                isOneTurn = dice != 6;
            }
            System.out.printf("Player %d rolls the dice and gets %d points.%n", currentPlayer, dice);
        }
        System.out.printf("Player %d win with %d points!%n", p1 > p2 ? 1: 2, Math.max(p1, p2));
    }
}
