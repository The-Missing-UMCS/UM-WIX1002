package com.umwix1002.solution.pastyear.PastYear2016.wix1002_2016_1;

import java.util.Random;
import java.util.Scanner;

public class Q2 {
    static String[] move = {"Paper", "Scissor", "Rock"};
    static Random rand = new Random();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int playerWinTime = 0, computerWinTime = 0;

            while (true) {
                System.out.print("Enter 1. Paper 2. Scissor 3. Rock: ");
                int playerMove = scanner.nextInt();
                int computerMove = rand.nextInt(1, 4);
                System.out.printf("Player : %s ----- Computer : %s%n", move[playerMove - 1], move[computerMove - 1]);

                if (playerMove == computerMove) {
                    System.out.println("Draw");
                    continue;
                }

                if ((playerMove - computerMove > 0) && (playerMove - computerMove % 2 == 1)) {
                    System.out.println("Player win " + ++playerWinTime + " time(s)");
                } else {
                    System.out.println("Computer win " + ++computerWinTime + " time(s)");
                }

                if (Math.max(playerWinTime, computerWinTime) == 3) {
                    break;
                }
            }

            System.out.printf("%s wins the game", playerWinTime == 3 ? "Player" : "Computer");
        }

    }
}
