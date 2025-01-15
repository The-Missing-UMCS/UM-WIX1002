package com.umwix1002.solution.lab.Lab6;

import java.util.Scanner;
import java.util.stream.IntStream;

public class L6Q3B {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[10]; 
		for(int i = 0; i < 10; i++) {
			System.out.printf("Enter a number (%d): ", i + 1);
			arr[i] = scanner.nextInt(); 
		}
		
		scanner.close();
		
		IntStream.of(arr).forEach(x -> System.out.print(x + " "));
		System.out.println("");
		IntStream.of(arr).map(x -> reverse(x)).forEach(x -> System.out.print(x + " "));

	}
	
	public static int reverse(int num) {
		int tmp = 0;
		
		while(num > 0) {
			tmp = tmp * 10 + (num % 10);
			num /= 10;
		}
		
		return tmp;
	}
}
