package com.umwix1002.solution.lab.Lab6;

public class L6Q4 {
	public static void main(String[] args) {
		System.out.println(findGCD(24, 8));
		System.out.println(findGCD(200, 625));
	}
	
	public static int findGCD(int a, int b) {
		return b == 0 ? a : findGCD(b, a % b);
	}
}
