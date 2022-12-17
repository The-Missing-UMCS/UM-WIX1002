package com.fyiernzy.ProblemSolving.PS2;

import java.util.Scanner;
public class PS2Q1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of stuff [N]: ");
		final int N = scanner.nextInt();
		scanner.close();
		
		int count = 0;
		for(int i = 0; i < N; i++) {
			int id = (int)(Math.random() * (100000 - 10000 + 1) + 10000);
			System.out.println("Staff ID: " + id);
			if ((id / 1000) % 2 == 1 && (id / 10) % 2 == 0) {
				System.out.println("Weekday on");
				count++;
			}
			else {
				System.out.println("Weekday off");
			}
		}

		System.out.println("The number of staffs work during weekend is " + count);

	}
}
