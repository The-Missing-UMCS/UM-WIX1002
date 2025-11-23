package com.umwix1002.solution.tutorial.Tutorial3;

import java.util.Scanner;
public class WIX1002_T3_Q5 {
	public static void main(String[] args) {
		System.out.print("Enter a year: ");
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		scanner.close();
		
		String text = "It's a leap year";
		
		if (year % 400 != 0) {
			if (year % 4 != 0 || year % 100 == 0) {
				text = "It's not a leap year";
			}
		}
		
		System.out.println(text);
		
	}
}
