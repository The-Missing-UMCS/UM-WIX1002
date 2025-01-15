package com.umwix1002.solution.lab.Lab5;

public class L5Q1 {
	public static void main(String[] args) {
		int sum = 0, n = 10, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = (int)(Math.random() * 101);
			sum += arr[i];
		
			if (arr[i] > max) 
				max = arr[i];
			else if (arr[i] < min)
				min = arr[i];
		}
		
		System.out.println("max = " + max);
		System.out.println("min = " + min);
		System.out.printf("average = %.2f", (sum / (double) n));
	}
}
