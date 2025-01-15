package com.umwix1002.solution.lab.lab8.l8q5;

import com.umwix1002.solution.lab.constants.CommonConstant;
import lombok.Data;

import static com.umwix1002.solution.lab.constants.CommonConstant.*;

/**
 * @author Ng Zhi Yang
 */
@Data
public class Game {
    private static final int DEFAULT_TARGET_POINTS = HUNDRED;
    
    private Player one;
    private Player two;
    private int targetPoints = DEFAULT_TARGET_POINTS;
    
    public Game(Player one, Player two) {
        this.one = one;
        this.two = two;
    }
    
    public void start() {
        boolean isOneTurn = (int) (Math.random() + ONE) == ONE;
        int p1 = ZERO, p2 = ZERO;
        
        while (Math.max(p1, p2) < targetPoints) {
            if (isOneTurn) {
                p1 += one.rollDice();
            } else {
                p2 += two.rollDice();
            }
            isOneTurn = !isOneTurn;
        }

        System.out.println(one + "'s points = " + p1);
        System.out.println(two + "'s points = " + p2);
        System.out.println((p1 >= targetPoints ? one : two) + " wins!");
    }
}
