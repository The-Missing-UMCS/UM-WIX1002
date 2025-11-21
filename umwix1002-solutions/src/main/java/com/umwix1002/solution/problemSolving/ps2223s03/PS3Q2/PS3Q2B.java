package com.umwix1002.solution.problemSolving.ps2223s03.PS3Q2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PS3Q2B {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter number of teams: ");
            int teamCount = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            Map<String, Integer> teamScores = new HashMap<>();

            for (int i = 1; i <= teamCount; i++) {
                System.out.printf("Enter team %d name: ", i);
                String teamName = scanner.nextLine();

                System.out.printf("Enter team %d score: ", i);
                int score = scanner.nextInt();
                scanner.nextLine(); // Consume the newline

                teamScores.put(teamName, score);
            }

            // Sort the map by values in descending order
            Map<String, Integer> sortedTeamScores = teamScores.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1, // Handle duplicate keys (not expected here)
                    LinkedHashMap::new
                ));

            System.out.println("List of teams with the highest scores first:");
            sortedTeamScores.forEach((team, score) ->
                System.out.printf("%s (%d) | ", team, score));
        }
    }
}

