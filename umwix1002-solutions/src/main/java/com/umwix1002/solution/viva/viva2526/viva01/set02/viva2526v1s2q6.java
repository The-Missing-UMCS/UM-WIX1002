package com.umwix1002.solution.viva.viva2526.viva01.set02;

import java.util.Random;
import java.util.Scanner;

public class viva2526v1s2q6 {

    public static void main(String[] args) {
        String input = """
            4 6 7 2 9 3 1 5 8 10
            """;

        try (Scanner scanner = new Scanner(input)) {
            Random random = new Random();
            // Initialize the chests
            char[] chests = new char[10];
            for (int i = 0; i < chests.length; i++) {
                chests[i] = '-';
            }
            for (int eggCount = 0; eggCount < 3; ) {
                int rand = random.nextInt(10);
                if (chests[rand] == '-') {
                    chests[rand] = 'E';
                    eggCount++;
                }
            }

            for (int cursedCnt = 0; cursedCnt < 2; ) {
                int rand = random.nextInt(10);
                if (chests[rand] == '-') {
                    chests[rand] = 'C';
                    cursedCnt++;
                }
            }

            System.out.println("""
                Welcome to the Dragon Egg Quest!
                There are 10 chests, 3 dragon eggs, and 2 cursed chests.
                You have 10 attempts to find all dragon eggs.
                """);

            int eggsFound = 0;
            for (int attemptsLeft = 10; attemptsLeft > 0 && eggsFound < 3; ) {

                if (!scanner.hasNextInt()) {
                    break;
                }

                int guess = scanner.nextInt();
                System.out.println("Guess a chest (1-10): " + guess);

                int index = guess - 1;
                int attemptCost = 1;

                if (chests[index] == 'C') {
                    System.out.println("This chest is cursed! Beware!");
                    attemptCost = 2;
                } else if (chests[index] == 'E') {
                    System.out.println("You found a dragon egg!");
                    eggsFound++;
                } else {
                    int nearestEggIndex = -1;
                    int nearestDistance = 100;

                    for (int i = 0; i < chests.length; i++) {
                        if (chests[i] == 'E') {
                            int distance = i - index;
                            if (distance < 0) {
                                distance = -distance;
                            }
                            if (distance < nearestDistance) {
                                nearestDistance = distance;
                                nearestEggIndex = i;
                            }
                        }
                    }

                    if (nearestDistance <= 3) {
                        System.out.println("Warm! You're very close to a dragon egg!");
                    } else {
                        System.out.println("Cold! You're far from any dragon egg!");
                    }

                    if (nearestEggIndex != -1) {
                        if (index < nearestEggIndex) {
                            System.out.println("Hint: Try a higher chest number.");
                        } else if (index > nearestEggIndex) {
                            System.out.println("Hint: Try a lower chest number.");
                        }
                    }

                    System.out.println("No egg here, keep searching!");
                }

                chests[index] = '-';
                attemptsLeft -= attemptCost;

                if (attemptsLeft > 0 && eggsFound < 3) {
                    System.out.println("Attempts left: " + attemptsLeft);
                    System.out.println();
                }
            }

            if (eggsFound == 3) {
                System.out.println("Congratulations! All dragon eggs are safe!");
            } else {
                System.out.println("Game Over! Some dragon eggs remain hidden!");
            }
        }
    }
}