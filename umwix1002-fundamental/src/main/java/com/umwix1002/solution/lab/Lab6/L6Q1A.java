package com.umwix1002.solution.lab.Lab6;


public class L6Q1A {
	public static void main(String[] args) {
		for(int i = 1; i <= 20; i++)
			System.out.print(triangular(i) + " ");
	}
	
	public static int triangular(int n) {
		return n <= 1 ? n : n + triangular(n - 1);
	}
}
