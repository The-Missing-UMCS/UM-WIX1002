package com.umwix1002.solution.lab.lab9.l9q4;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class DiceGame {
    protected static final int DEFAULT_TARGET_SCORE = 100;
    protected static final int DEFAULT_DICE_SIDES = 6;
    
    protected DicePlayer one;
    protected DicePlayer two;

    public void gamePlay() {
        boolean isOneTurn = true;
        while(true) {
            DicePlayer currentPlayer = isOneTurn ? one : two;
            notifyTakeTurn(currentPlayer);
            System.out.printf("%s's points = %d\n", currentPlayer, currentPlayer.getPoints());
            if (hasWon(currentPlayer)) {
                break;
            }
            isOneTurn = !isOneTurn;
        }
        System.out.printf("%s won!\n", (hasWon(one)) ? one : two);
    }

    /**
     * Notify the player to take their turn. The player will roll the dice according to the game's rules.
     * @param player The player to take their turn.
     */
    abstract void notifyTakeTurn(DicePlayer player);

    /**
     * Check if the player has won the game.
     * @param player The player to check if they have won the game.
     * @return True if the player has won the game, false otherwise.
     */
    abstract boolean hasWon(DicePlayer player);
}
