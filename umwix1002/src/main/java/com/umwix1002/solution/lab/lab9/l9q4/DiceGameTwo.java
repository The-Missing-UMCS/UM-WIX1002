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

        if (player.rollDice() == DEFAULT_DICE_SIDES) {
            if (player.rollDice() == DEFAULT_DICE_SIDES) {
                player.setPoints(tmp);
            }
        }

        if (player.getPoints() > DEFAULT_TARGET_SCORE) {
            player.setPoints(tmp);
        }
        
        System.out.printf("%s's points = %d\n", player, player.getPoints());
    }

    @Override
    public void gamePlay() {
        boolean isOneTurn = true;
        while(true) {
            DicePlayer currentPlayer = isOneTurn ? one : two;
            notifyTakeTurn(currentPlayer); 
            if (currentPlayer.getPoints() == DEFAULT_TARGET_SCORE) {
                break;
            }
            isOneTurn = !isOneTurn;
        }
        System.out.printf("%s won!\n", (one.getPoints() == DEFAULT_TARGET_SCORE) ? one : two);
    }

}
