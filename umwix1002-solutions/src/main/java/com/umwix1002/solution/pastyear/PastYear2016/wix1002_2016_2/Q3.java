package com.umwix1002.solution.pastyear.PastYear2016.wix1002_2016_2;

public class Q3 {
	public static void main(String[] args) {
		printPyramid(20);
	}
	
	public static void printPyramid(int N) {
		int maxCount = getDigitCount(N);
		
		for(int i = 1; i <= N; i++) {
			System.out.print(" ".repeat((1 + maxCount) * (N - i)));
			for(int j = i; j > 1; j--) {
				System.out.print(j + " ".repeat(maxCount - getDigitCount(j) + 1));
			}
			
			System.out.print(1 + " ".repeat(maxCount));
			
			for(int j = 2; j <= i; j++) {
				System.out.print(j + " ".repeat(maxCount - getDigitCount(j) + 1));
			}
			
			System.out.println();
		}
		
//		for(int i = 1; i <= N; i++) {
//			System.out.print(" ".repeat(2 * (N - i)));
//			for(int j = i; j > 1; j--) {
//				System.out.print(j + " ");
//			}
//			
//			System.out.print(1 + " ");
//			
//			for(int j = 2; j <= i; j++) {
//				System.out.print(j + " ");
//			}
//			
//			System.out.println();
//		}
	}
	
	public static int getDigitCount(int N) {
		int tmp = N, count = 0;
		
		while(tmp > 0) {
			count++;
			tmp /= 10;
		}
		
		return count;
	}
}
