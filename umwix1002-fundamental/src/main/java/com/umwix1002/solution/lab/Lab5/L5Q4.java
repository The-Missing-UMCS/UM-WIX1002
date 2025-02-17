package com.umwix1002.solution.lab.Lab5;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class L5Q4 {
	public static void main(String[] args) {
		int tmp, n;
		
		// Original Array
		int[][] arr = new int[3][3];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Random().ints(3, 1, 9).toArray();
		}
		
		for(int i = 0; i < arr.length; i++) {
			IntStream.of(arr[i]).forEach(x-> System.out.print(x + " "));
			System.out.println("");
		}
		
		
		// Method 1
		int[][] copy = copy(arr);
		
		// Corner
		arr[0][0] = copy[2][0];
		arr[2][0] = copy[2][2];
		arr[2][2] = copy[0][2];
		arr[0][2] = copy[0][0];
		
		// Side
		arr[0][1] = copy[1][0];
		arr[1][0] = copy[2][1];
		arr[2][1] = copy[1][2];
		arr[1][2] = copy[0][1];
		
		System.out.println("");
		for(int i = 0; i < arr.length; i++) {
			IntStream.of(arr[i]).forEach(x-> System.out.print(x + " "));
			System.out.println("");
		}
		
		// Method 2
		System.out.println("");
		for(int i = 0; i < arr.length; i++) {
			for(int j = arr.length - 1; j >= 0; j--){
				System.out.print(arr[j][i] + " ");
			}
			System.out.println("");
		}
		
		// Method 3
		System.out.println("");
		for(int i = 0; i < arr.length / 2; i++) {
			for(int j = i; j < arr[i].length - 1 - i; j++) {
				n = arr[i].length;
				tmp = arr[i][j];
				arr[i][j] = arr[j][n - i - 1];
				arr[j][n - i - 1] = arr[n - i - 1][n - j - 1];
				arr[n - i - 1][n - j - 1] = arr[n - j - 1][i];
				arr[n - j - 1][i] = tmp;
			}
		}
		
		// Method credit to: https://github.com/LimJY03/WIX1002_UM/blob/main/Lab%2005/L5Q4.java
		/*
		Scanner sc = new Scanner(System.in);
        String[][] matrix = new String[3][3];

        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                matrix[j][i] = sc.next();
            }
        }

        String temp = String.join(
                "\n",
                String.join(" ", matrix[0]),
                String.join(" ", matrix[1]),
                String.join(" ", matrix[2])
        );

        System.out.println(temp);

        sc.close();
		 */
	}
	
	public static int[][] copy(int[][] src) {
		return Arrays.stream(src).map(int[]::clone).toArray(int[][]::new);
		// https://www.techiedelight.com/create-copy-of-2d-array-java/
    }
}
