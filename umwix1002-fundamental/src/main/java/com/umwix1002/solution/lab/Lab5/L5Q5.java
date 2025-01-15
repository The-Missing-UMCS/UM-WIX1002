package com.umwix1002.solution.lab.Lab5;

import java.util.*;

public class L5Q5 {
	public static void main(String[] args) {
		System.out.println("A list of 20 random integers within 0 and 100");
		int[] arr = new Random().ints(20, 0, 100).toArray();
		printArray(arr);

		System.out.println("Array in descending order");
		reverse(arr);
		printArray(arr);

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number to search: ");
		int x = scanner.nextInt();
		scanner.close();

		Arrays.sort(arr);
		linearSearch(arr, x);
		binarySearch(arr, x);
	}

	public static void binarySearch(int[] arr, int x) {
		int cnt = 1, low = 0, mid = 0, high = arr.length - 1;

		while (low <= high) {
			mid = (low + high) / 2;

			if (arr[mid] == x) {
				System.out.printf("%d found. Binary Search - %d loop%s\n", x, cnt, (cnt > 1) ? "s" : "");
				return ;
			}

			if (arr[mid] > x)
				high = mid - 1;
			else
				low = mid + 1;
		}

		System.out.printf("Binary Search - %d not found", x);
	}

	public static void linearSearch(int[] arr, int x) {
		for (int i = 0, cnt = 1; i < arr.length; i++, cnt++) 
			if (arr[i] == x) {
				System.out.printf("%d found. Linear Search - %d loop%s\n", x, cnt, (cnt > 1) ? "s" : "");
				return;
			}
		System.out.printf("Linear Search - %d + not found", x);
	}

	public static void reverse(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length / 2; i++) {
			int tmp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = tmp;
		}
	}

	public static void printArray(int[] arr) {
		System.out.println(Arrays.toString(arr).replaceAll("[\\[\\]]", ""));
	}

}
