package Lab5;


import java.util.*;

public class L5Q5 {
	public static void main(String[] args) {
		int[] arr = new Random().ints(20, 0, 100).toArray();
		
		Arrays.sort(arr);
		
		System.out.println("A list of 20 random integers within 0 and 100");
		printArray(arr);
		System.out.println("");
		
		reverse(arr);
		
		System.out.println("Array in descending order");
		printArray(arr);
		System.out.println("");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number to search: ");
		int x = scanner.nextInt();
		scanner.close();
		
		Arrays.sort(arr);

		linearSearch(arr, x);
		binarySearch(arr, x);
	}
	
	public static void binarySearch(int[] arr, int x) {
		int counter = 1, low = 0, mid = 0, high = arr.length - 1;
		
		while (low <= high) {
			mid = (low + high) / 2;
			
			if (arr[mid] == x) {
				System.out.println(x + " found");
				System.out.println("Binary Search - " + counter + " loop(s)");
				break;
			}
			
			if (arr[mid] > x)
				high = mid - 1;
			else
				low = mid + 1;
			
			counter++;
		}
		
		if (low > high)
			System.out.println("Binary Search - " + x + " not found");
	}
	
	public static void linearSearch(int[] arr, int x) {
		int counter = 1;
		
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] == x) {
				System.out.println(x + " found");
				System.out.println("Linear Search - " + counter + " loop(s)");
				break;
			}
			counter++;
		}
		
		if (counter > arr.length)
			System.out.println("Linear Search - " + x + " not found");
	}
	
	public static void reverse(int[] arr) {
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length / 2; i++) {
			int tmp = arr[i];
			arr[i] = arr[arr.length - i - 1];
			arr[arr.length - i - 1] = tmp;
		}
		
	}
	
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) 
			System.out.print(arr[i] + ((i < arr.length - 1) ? ", " : ""));
	}
	
}
