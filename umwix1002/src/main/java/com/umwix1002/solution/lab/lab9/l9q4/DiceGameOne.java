package com.umwix1002.solution.lab.lab9.l9q4;

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
        } else {
            System.out.printf("%s's points = %d\n", player, player.getPoints());
        }
    }

    @Override
    public void gamePlay() {
        boolean isOneTurn = true;
        while(true) {
            DicePlayer currentPlayer = isOneTurn ? one : two;
            notifyTakeTurn(currentPlayer);
            if (currentPlayer.getPoints() >= DEFAULT_TARGET_SCORE) {
                break;
            }
            isOneTurn = !isOneTurn;
        }
        System.out.printf("%s won!\n", (one.getPoints() >= DEFAULT_TARGET_SCORE) ? one : two);
    }
}
