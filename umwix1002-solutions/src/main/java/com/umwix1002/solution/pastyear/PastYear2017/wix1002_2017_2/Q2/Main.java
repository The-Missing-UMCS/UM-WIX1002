package com.umwix1002.solution.pastyear.PastYear2017.wix1002_2017_2.Q2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter number of teams: ");
            final int N = sc.nextInt();
            sc.nextLine();
            Team[] teams = new Team[N];
            for (int i = 1; i <= N; i++) {
                System.out.printf("Enter team %d name: ", i);
                String name = sc.nextLine();
                System.out.printf("Enter team %d score: ", i);
                int score = sc.nextInt();
                sc.nextLine();
                teams[i - 1] = new Team(name, score);
            }
            System.out.println("List of team with the highest team score first");
            Arrays.sort(teams, (t1, t2) -> -1 * Integer.compare(t1.getScore(), t2.getScore()));
            Arrays.stream(teams).forEach((team) -> System.out.print(team + " | "));
        }
    }
}
