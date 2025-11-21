package com.umwix1002.solution.problemSolving.ps2223s03;

import java.util.Scanner;

public class PS3Q1 {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) {
			int N;
			System.out.print("Enter a number: ");
			N = scanner.nextInt();
			System.out.println("The first " + N + " triangular numbers");
			for(int i = 1; i <= N; i++) {
				System.out.print(getTriangular(i) + " ");
			}
			System.out.println();
		}
	}
	
	public static int getTriangular(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}
}
