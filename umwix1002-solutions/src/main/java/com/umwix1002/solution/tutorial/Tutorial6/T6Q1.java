package com.umwix1002.solution.tutorial.Tutorial6;

/*
 * https://stackoverflow.com/questions/4727569/how-to-check-whether-input-value-is-integer-or-float
 * Reference: https://www.javatpoint.com/factorial-program-in-java
 * https://www.geeksforgeeks.org/check-if-given-number-is-perfect-square-in-cpp/
 * https://www.javatpoint.com/java-hashset
 * https://stackoverflow.com/questions/12455737/how-to-iterate-over-a-set-hashset-without-an-iterator
 */
import java.util.*;
import java.util.stream.*;

public class T6Q1 {
	static int[] arr = new int[10];
	
	public static void main(String[] args) {
		
	}
	
	public static int findMax(int... args) {
		return IntStream.of(args).max().orElseThrow(NoSuchElementException::new);
	}
	
	public static boolean checkSquare(int x) {
		int root = (int) Math.sqrt(x);
		int perfectSquare = (int) Math.pow(root, 2);
		return (perfectSquare == x);
	}
	
	public static int combination(int n, int k) {
		return factorial(n) / (factorial(k) * factorial(n - k));
	}
	
	public static int factorial(int x) {
		if (x == 0 || x == 1) 
			return 1;
		else
			return x * factorial(x - 1);
	}
	
	public static boolean checkPentagonal(int Pn) {
		if (Pn <= 0 && (Pn != (int) Pn))
			return false;
		
		double ans = ((1 + Math.sqrt(1 + 24 * Pn)) / (double) 6);
		return (ans == (int) ans);
	}
	
	public static void displayCount(String str) {
		int digitCount = 0, charCount = 0;
		
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.isDigit(ch))
				digitCount++;
			
			if (Character.isLetter(ch))
				charCount++;
		}
		
		System.out.println("Digit count = " + digitCount);
		System.out.println("Char count  = " + charCount);
	}
	
	public static void generateNumber() {
		arr = new Random().ints(10, 0, 100).toArray();
	}
	
	public static void calcCircle(double radius) {
		System.out.printf("Circumference = %f\n", (Math.PI * 2 * radius));
		System.out.printf("Circumference = %f\n", (Math.PI * radius * radius));
	}
	
	public static int findFirstGenerateTwice() {
		HashSet<Integer> hs = new HashSet<Integer>();
		while (true) {
			int num = new Random().nextInt(11);
			if (!hs.add(num)) {
				System.out.println("HashSet     = " + hs);
				System.out.println("Next number = " + num);
				return num;
			}
				
		}
	}
}
