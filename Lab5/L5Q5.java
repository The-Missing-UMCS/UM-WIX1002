package Lab5;

/*
 * Questions:
 * ===========
 * Write a program that generates 20 random integers within the range from 0 to 100. 
 * Sort the array in descending order. Then, accepts an integer input from the user. Then, 
 * search the array using this number. Compare the performance of linear search and 
 * binary search.
 */


/*
 * Reference:
 * ============
 * 1. https://www.programiz.com/dsa/binary-search
 * 2. https://www.geeksforgeeks.org/binary-search/
 */

import java.util.*;
import java.util.stream.IntStream;
public class L5Q5 {
	public static void main(String[] args) {
		int[] arr = new Random().ints(20, 0, 100).toArray();
		System.out.println("A list of 20 random integer within 0 to 100");
		IntStream.of(arr).forEach(x -> System.out.print(x + " "));
		
		// BubbleSort
		System.out.println("\n");
		System.out.println("Array in descending order (Bubble Sort)");
		arr = bubbleSort(arr);
		IntStream.of(arr).forEach(x -> System.out.print(x + " "));
		
		// SelectionSort
		System.out.println("\n");
		System.out.println("Array in descending order (Selection Sort)");
		arr = selectionSort(arr);
		IntStream.of(arr).forEach(x -> System.out.print(x + " "));
		
		// InsertionSort
		System.out.println("\n");
		System.out.println("Array in descending order (Insertion Sort)");
		arr = insertionSort(arr);
		IntStream.of(arr).forEach(x -> System.out.print(x + " "));
		
		// Searching Algorithm
		System.out.println("\n");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number to search: ");
		int x = scanner.nextInt();
		scanner.close();
		
		linearSearchVoid(arr, x);
		
		int low = 0, high = arr.length;
		binarySearchVoid(arr, x, low, high);
		
	}
	
	public static int[] bubbleSort(int[] arr) {
		int tmp;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] < arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		return arr;
	}
	
	public static int[] selectionSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int min = findMax(arr, i);
			int index = linearSearch(arr, min);
			int tmp = arr[i];
			arr[i] = arr[index];
			arr[index] = tmp;
		}
		return arr;
	}
	
	public static int[] insertionSort(int[] arr) {
		int tmp = 0;
		for(int i = 1; i < arr.length; i++) {
			innerLoop: for(int j = 0; j < i; j++) {
				if (arr[i] > arr[i-1]) {
					tmp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = tmp;
				} else {
					break innerLoop;
				}
			}
		}
		return arr;
	}
	
	public static void linearSearchVoid(int[] arr, int x) {
		int counter = 0;
		for(int i = 0; i < arr.length; i++) {
			counter++;
			if (arr[i] == x) {
				System.out.println(x + " found");
				System.out.println("Linear search - " + counter + " loop(s)");
				break;
			}	
		}
		
		if (counter == arr.length) 
			System.out.println(x + " not found");
	}
	
	public static void binarySearchVoid(int[] arr, int x, int low, int high) {
		int counter = 0;
		while(low <= high) {
			counter++;
			
			int mid = low + (high - low) / 2;
			if (arr[mid] == x) {
				System.out.println(x + " found");
				System.out.println("Binary search - " + counter + " loop(s)");
				break;
			}
			
			if (arr[mid] > x) 
				low = mid + 1;
			else 
				high = mid - 1;
		}
		
		if (high < low) {
			System.out.println(x + " not found");
		}
	}
	
	public static int linearSearch(int[] arr, int target) {
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}	
		}
		return -1;
	}
	
	public static int binarySearch1(int[] arr, int x, int low, int high) {
		while(high > low) {
			int mid = low + (high - low) / 2;
			
			if (arr[mid] == x)
				return mid;
			
			if (arr[mid] < x)
				low = mid + 1;
			else
				high = mid - 1;
		}
		
		return -1;
	}
	
	public static int binarySearch2(int[] arr, int x, int low, int high) {
		if (high > low) {
			int mid = low + (high - low) / 2;
			
			if (arr[mid] == x) {
				return mid;
			}
			
			if (arr[mid] < x) {
				return binarySearch2(arr, x, mid + 1, high);
			}
			
			return binarySearch2(arr, x, low, mid - 1);
		}
		
		return -1;
	}

	public static int findMin(int[] arr, int fromIndex) {
		int min = Integer.MAX_VALUE;
		for(int i = fromIndex; i < arr.length; i++) {
			if (arr[i] < min)
				min = arr[i];
		}
		return min;
	}
	
	public static int findMax(int[] arr, int fromIndex) {
		int max = Integer.MIN_VALUE;
		for(int i = fromIndex; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		
		return max;
	}
	
	
}
