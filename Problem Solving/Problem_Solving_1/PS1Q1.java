package com.fyiernzy.ProblemSolving.PS1;

import java.util.Scanner;
public class PS1Q1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x, y;
		
		System.out.print("Enter the coordinate x and y: ");
		x = scanner.nextInt();
		y = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("Enter the move: ");
		String move = scanner.nextLine().toUpperCase();
		
		scanner.close();
		
		System.out.printf("Initial Coordinate: (%d, %d)\n", x, y);
		
		for(int i = 0; i < move.length(); i++) {
			switch(move.charAt(i)) {
			case 'R' -> x++;
			case 'L' -> x--;
			case 'U' -> y++;
			case 'D' -> y--;
			}
		}
		
		System.out.printf("Final Coordinate: (%d, %d)", x, y);
		
		
	}
}
