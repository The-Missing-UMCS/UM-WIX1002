package com.umwix1002.solution.tutorial.Tutorial4;

public class WIX1002_T4_Q2 {
	public static void main(String[] args) {
		System.out.println("Question A");
		int sum = 0;
		for (int x = 10; x > 0; x--)
			sum += x;
		System.out.println("Sum = " + sum);
		
		System.out.println("");
		System.out.println("Question B");
		int x = 0;
		int y = 0;
		do {
			x += 2;
			y += x;
			System.out.println(x + " and " + y);
		} while (x < 100);
		
		System.out.println("");
		System.out.println("Question C");
		for (int i = 1, j = 20; i < j; i++, j -= 2) {
			System.out.println(i + " " + j);
		}
		
		System.out.println("");
		System.out.println("Question D");
		int i = 1;
		while (i <= 10) {
			if (i == 10) {
				System.out.println("Program End");
				break;
			}
			i++;
				

		}
				 
	}
}
