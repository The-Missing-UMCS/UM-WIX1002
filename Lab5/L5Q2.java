package Lab5;

/*
 * Some solutions are from: https://www.geeksforgeeks.org/check-if-a-value-is-present-in-an-array-in-java/
 */

import java.util.*;
import java.util.stream.*;

public class L5Q2 {
	public static void main(String[] args) {
		// Method 1
		int[] arr = new int[10];
		int randomNum;
		for(int i = 0; i < arr.length; ) {
			randomNum = (int)(Math.random() * 21);
			// Any searching method can be applied here
			if (!(streamMatch(arr, randomNum))) 
				arr[i++] = randomNum;
		}
		// Source: https://www.geeksforgeeks.org/how-to-print-elements-of-a-stream-in-java-8/
		IntStream.of(arr).forEach(s -> System.out.print(s + " "));
		
		System.out.println("");
		
		// Method 2
		ArrayList<Integer> list = new ArrayList<Integer>();
		int random;
		while(list.size() < 10) {
			random = (int)(Math.random() * 21);
			if (!streamMatch(list, random))
				list.add(random);
		}
		Stream.of(list).forEach(s -> System.out.print(s + " "));
	}
	
	public static boolean linearSearch(int[] list, int target) {
		// Time complexity: O(N)
		for(int n : list) {
			if (n == target)
				return true;
		}
		return false;
	}
	
	public static boolean binarySearch(int[] list, int target) {
		// Time complexity: O(nlog(n))
		Arrays.sort(list);
		return Arrays.binarySearch(list, target) > 0 ? true : false;
	}
	
	public static boolean listContain(int[] list, int target) {
		// Time complexity: O(N)
		return Arrays.asList(list).contains(target);
	}
	
	public static boolean streamMatch(int[] list, int target) {
		// IntStream.of converts the list to int[] stream
		// Therefore, .anyMatch() can be used to check if the target is within the list
		return IntStream.of(list).anyMatch(x -> x == target);
	}
	
	// Overload
	public static boolean streamMatch(ArrayList<Integer> list, int target) {
		// Source: https://www.dotnetperls.com/stream-java
		return list.stream().anyMatch(x -> x ==  target);
	}
	
}
