package com.umwix1002.solution.lab.lab08.l8q5;

public class Game {

    private final String p1Name;
    private final String p2Name;

    public Game(String p1Name, String p2Name) {
        this.p1Name = p1Name;
        this.p2Name = p2Name;
    }

    public void start() {
        boolean isOneTurn = (int) (Math.random() + 1) == 1;
        int p1 = 0, p2 = 0, targetPoints = 100;

        while (Math.max(p1, p2) < targetPoints) {
            int points = move();
            if (isOneTurn) {
                p1 += points;
            } else {
                p2 += points;
            }
            isOneTurn = !isOneTurn;
        }

        System.out.printf("""
                %s's points = %d
                %s's points = %d
                %s wins!
                """,
            p1Name, p1,
            p2Name, p2,
            (p1 >= targetPoints ? p1Name : p2Name)
        );
    }

    private int move() {
        int min = 1, max = 6, range = max - min + 1;
        return (int) (Math.random() * range + 1);
    }
}
