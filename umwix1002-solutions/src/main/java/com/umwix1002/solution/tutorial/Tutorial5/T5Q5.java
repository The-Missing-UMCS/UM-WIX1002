package com.umwix1002.solution.tutorial.Tutorial5;

import java.util.Scanner;

public class T5Q5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your sentence here: ");
		String sentence = scanner.nextLine();
		scanner.close();
		
		// Method 1
		for(int i = sentence.length() - 1; i >= 0; i--) {
			System.out.print(sentence.charAt(i));
		}
		
		System.out.println("");
		
		// Method 2
		String[] arr = sentence.split("");
		for(int i = sentence.length() - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}

		// Method 3
		System.out.println(new StringBuilder(sentence).reverse().toString());
	}
}
