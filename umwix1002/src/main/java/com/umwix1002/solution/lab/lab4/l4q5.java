package com.umwix1002.solution.lab.lab4;

/**
 * @author Ng Zhi Yang
 */
public class l4q5 {
    public static void main(String[] args) {
        int p1 = 0, p2 = 0, dice; boolean isOneTurn = true;
        while(Math.max(p1, p2) <= 100) {
            dice = (int) (Math.random() * 6 + 1);
            if(isOneTurn) {
                p1 += dice;
                isOneTurn = dice == 6;
            } else {
                p2 += dice;
                isOneTurn = dice != 6;
            }
        }
        System.out.printf("Player %s win with %d points!\n", (p1 > p2 ? "1" : "2"), Math.max(p1, p2));
    }
}
