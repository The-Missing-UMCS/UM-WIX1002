package com.umwix1002.solution.lab.lab8.l8q5;

import static com.umwix1002.solution.lab.constants.CommonConstant.ONE;

/**
 * @author Ng Zhi Yang
 */
public interface DicePlayable {
    default int rollDice() {
        return (int) (Math.random() * 6) + ONE;
    }
}
