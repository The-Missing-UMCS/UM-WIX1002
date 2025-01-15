package com.umwix1002.solution.lab.Lab6;


public class L6Q1B {
	public static void main(String[] args) {
		for(int i = 1; i <= 20; i++)
			System.out.print(triangular(i) + " ");
	}
	
	public static int triangular(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++)
			sum += i;
		return sum;
	}
}
