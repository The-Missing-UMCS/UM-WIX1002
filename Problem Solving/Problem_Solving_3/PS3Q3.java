package com.fyiernzy.ProblemSolving.PS3;

import java.util.stream.IntStream;
import java.util.Random;
import java.util.Scanner;

public class PS3Q3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an integer value: ");
		int n = scanner.nextInt();
		scanner.close();
		int[] arr = new Random().ints(n, 0, 10001).toArray();
		
		System.out.println("Min: " + getMin(arr));
		
		System.out.print("Show Normal Integer : ");
		showInteger(arr);
		System.out.println("");
		
		System.out.print("Show Rounded Integer: ");
		showRoundedInteger(arr);
		System.out.println("");
		
		System.out.print("Show Reverse Integer: ");
		showReverseInteger(arr);
		System.out.println("");
	}
	
	public static void showInteger(int[] arr) {
		IntStream.of(arr).forEach(x -> System.out.print(x + " "));
	}
	
	public static int getMin(int[] arr) {
		return IntStream.of(arr).min().getAsInt();
	}
	
	public static int roundHundred(int n) {
		return ((n + 50) / 100) * 100;
	}
	
	public static void showRoundedInteger(int[] arr) {
		IntStream.of(arr).map(PS3Q3::roundHundred).forEach(x -> System.out.print(x + " "));
	}
	
	public static void showReverseInteger(int[] arr) {
		for(int i = arr.length - 1; i >= 0; i--) System.out.print(arr[i] + " ");
	}
}
