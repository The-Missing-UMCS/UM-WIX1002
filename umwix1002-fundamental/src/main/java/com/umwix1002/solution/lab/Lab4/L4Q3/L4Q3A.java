package com.umwix1002.solution.lab.Lab4.L4Q3;

import java.util.*;
public class L4Q3A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int num = 0;
		while(true) {
			System.out.print("Enter a score [negative score to quit]: ");
			if((num = sc.nextInt()) < 0) break;
			arr.add(num);
		}
		sc.close();

		System.out.println("Minimum Score: " + findMin(arr));
		System.out.println("Maximum Score: " + findMax(arr));
		System.out.printf("Average Score: %.2f\n",findAverage(arr));
		System.out.printf("Standard Deviation: %.2f\n ", findStd(arr));
	}
	
	public static int findMin(ArrayList<Integer> arr) {
		int min = Integer.MAX_VALUE;
		for(int i : arr)
			if (i < min)
				min = arr.get(i);
		return min;
	}
	
	public static int findMax(ArrayList<Integer> arr) {
		int max = Integer.MIN_VALUE;
		for(int i : arr)
			if(i > max)
				max = arr.get(i);
		return max;
	}
	
	public static int findSum(ArrayList<Integer> arr) {
		int total = 0;
		for(int i : arr)
			total += i;
		return total;
	}
	
	public static double findAverage(ArrayList<Integer> arr) {
		return findSum(arr) / (double) arr.size();
	}
	
	public static int findSquaredSum(ArrayList<Integer> arr) {
		int sum = 0;
		for(int i : arr)
			sum += (int) (Math.pow(i, 2));
		return sum;
	}
	
	public static double findStd(ArrayList<Integer> arr) {
		int n = arr.size();
		double squaredAverage = Math.pow(findAverage(arr), 2);
		double variance = (findSquaredSum(arr) - (squaredAverage / n)) / (double)(n - 1);
		return Math.sqrt(variance);
	}
}
