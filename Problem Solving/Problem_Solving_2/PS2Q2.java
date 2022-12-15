package com.fyiernzy.ProblemSolving.PS2;

import java.util.Scanner;

public class PS2Q2 {
	public static void main(String[] args) {
		int dividend, factor, points = 0, questions = 0;
		boolean ans;
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.print("Enter a number (-1 to quit): ");
			dividend = scanner.nextInt();
			
			if (dividend < 0)
				break;
			
			questions++;
			System.out.print("Enter a factor: ");
			factor = scanner.nextInt();
			
			System.out.printf("%d is a factor of %d? (true/false): ", factor, dividend);
			ans = scanner.nextBoolean();
			
			if ((dividend % factor == 0) == ans) {
				points++;
				System.out.println("Your answer is correct.");
			} else {
				System.out.println("Your answer is incorrect.");
			}
		}
		
		scanner.close();
		System.out.printf("The final score is %d/%d", points, questions);
		
		
	}
}
