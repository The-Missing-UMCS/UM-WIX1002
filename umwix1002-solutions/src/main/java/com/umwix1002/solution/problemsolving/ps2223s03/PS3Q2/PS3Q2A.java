package com.umwix1002.solution.problemsolving.ps2223s03.PS3Q2;

import java.util.Arrays;
import java.util.Scanner;

public class PS3Q2A {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 1. Get the number of team
            System.out.print("Enter number of team: ");
            int N = scanner.nextInt();
            scanner.nextLine();

            Team[] teams = new Team[N];

            // 2. Initialize each team
            for (int i = 0; i < N; i++) {
                System.out.printf("Enter team %d name: ", (i + 1));
                String teamName = scanner.nextLine();

                System.out.printf("Enter team %d score: ", (i + 1));
                int teamScores = scanner.nextInt();
                scanner.nextLine();

                teams[i] = new Team(teamName, teamScores);
            }

            // 3. Sort the team by score and print the result
            Arrays.sort(teams);
            System.out.println("List of team with the highest team score first");
            Arrays.stream(teams)
                .forEach(team -> System.out.printf("%s (%d) | ", team.name(), team.scores()));
        }
    }
}