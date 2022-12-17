package com.fyiernzy.ProblemSolving.PS3;

import java.util.Arrays;
import java.util.Scanner;
public class PS3Q2_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int N; String teamName; int teamScores;
		
		System.out.print("Enter number of team: ");
		N = scanner.nextInt();
		scanner.nextLine();
		Team[] teamArray = new Team[N];
		
		for(int i = 0; i < N; i++) {
			System.out.printf("Enter team %d name: ", (i + 1));
			teamName = scanner.nextLine();
			System.out.printf("Enter team %d score: ", (i + 1));
			teamScores = scanner.nextInt();
			scanner.nextLine();
			teamArray[i] = new Team(teamName, teamScores);
		}
		
		scanner.close();
		Arrays.sort(teamArray);
		System.out.println("List of team with the highest team score first");
		for(int i = 0; i < teamArray.length; i++)
			System.out.printf("%s (%d) | ", teamArray[i].getName(), teamArray[i].getScores());
		
	}
}

class Team implements Comparable<Team> {
	private final String TEAM_NAME;
	private int teamScores;
	
	Team(String name, int teamScores) {
		this.TEAM_NAME = name;
		this.teamScores = teamScores;
	}
	
	@Override
	public int compareTo(Team another) {
		return (-1 * Integer.compare(this.getScores(), another.getScores()));
	}
	
	public String getName() {
		return this.TEAM_NAME;
	}
	
	public int getScores() {
		return this.teamScores;
	}
}