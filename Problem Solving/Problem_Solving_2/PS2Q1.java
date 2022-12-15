package com.fyiernzy.ProblemSolving.PS2;

import java.util.Scanner;
public class PS2Q1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of stuff [N]: ");
		final int N = scanner.nextInt();
		scanner.close();
		
		for(int i = 0; i < N; i++) {
			int id = (int)(Math.random() * 100000 + 10000);
			System.out.println("Staff ID: " + id);
			System.out.println(((id / 1000) % 2 == 1 && (id / 10) % 2 == 0) ? "Weekday on" : "Weekday off");
		}
	}
}
