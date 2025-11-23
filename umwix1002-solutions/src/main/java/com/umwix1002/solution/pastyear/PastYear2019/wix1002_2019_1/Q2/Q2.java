package com.umwix1002.solution.pastyear.PastYear2019.wix1002_2019_1.Q2;

import java.util.Random;
import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		int[][] a, b;
		int N;
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("Enter N: ");
			N = scanner.nextInt();
			
			if(N <= 0)
				break;
			
			a = generateMatrix(N);
			b = generateMatrix(N);
			
			System.out.println("Matrix A");
			displayMatrix(a);
			
			System.out.println("Matrix B");
			displayMatrix(b);
			
			System.out.println("Matrix A + B");
			displayMatrix(addMatrix(a, b));
			
			System.out.println("Matrix A X B");
			displayMatrix(multiplyMatrix(a, b));
			
			System.out.println();
		}
		
		scanner.close();
	}
	
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		Random random = new Random();
		
		for(int i = 0; i < n; i++) 
			matrix[i] = random.ints(n, 0, 9).toArray();
		
		return matrix;
	}
	
	public static void displayMatrix(int[][] matrix) {
		int n = matrix.length;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static int[][] addMatrix(int[][] a, int[][] b) {
		checkSameDimension(a, b);
		
		int row = a.length;
		
		int[][] added = new int[row][];
		for(int i = 0; i < row; i++) {
			int column = a.length;
			added[i] = new int[column];
			for(int j = 0; j < column; j++) {
				added[i][j] = a[i][j] + b[i][j];
			}
		}
		
		return added;
	}
	
	public static int[][] multiplyMatrix(int[][] a, int[][] b) {
		checkSameDimension(a, b);
		checkSquareMatrix(a, b);
		
		int d = a.length;
		int[][] mul = new int[d][d];
		
		for(int row = 0; row < d; row++) {
			for(int column = 0; column < d; column++) {
				for(int i = 0; i < d; i++) {
					mul[row][column] += a[row][i] + b[i][column];
				}
			}
		}
		
		return mul;
	}
	
	public static boolean isSquareMatrix(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			if(m[i].length != m.length)
				return false;
		}
		return true;
	}
	
	public static void checkSquareMatrix(int[][] a, int[][] b) {
		if(!isSquareMatrix(a) || !isSquareMatrix(b))
			throw new IllegalStateException("Not square matrix");
	}
	
	public static void checkSameDimension(int[][] a, int[][] b) {
		if(a.length != b.length)
			throw new IllegalStateException("Different dimension a, b");
		
		int row = a.length;
		
		for(int i = 0; i < row; i++) {
			if(a[i].length != b[i].length)
				throw new IllegalStateException("Different dimension a, b");
		}
	}
	
	
}
