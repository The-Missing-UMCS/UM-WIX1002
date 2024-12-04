package com.umwix1002.solution.lab.lab9.l9q4;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    public static void main(String[] args) {
        DicePlayer one = new DicePlayer("Player 1");
        DicePlayer two = new DicePlayer("Player 2");
        DiceGame dicegame = new DiceGameOne(one, two);
        dicegame.gamePlay();
    }
}
