package Lab6;

import java.util.Scanner;

public class L6Q3A {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[10]; 
		for(int i = 0; i < 10; i++) {
			System.out.printf("Enter a number (%d): ", i + 1);
			arr[i] = scanner.nextInt(); 
		}
		
		scanner.close();
		
		for(int i : arr) 
			System.out.print(i + " ");

		System.out.println("");

		for(int i : arr) 
			System.out.print(reverse(i) + " ");

	}
	
	public static int reverse(int num) {
		int tmp = 0;
		
		while(num > 0) {
			tmp = tmp * 10 + (num % 10);
			num /= 10;
		}
		
		return tmp;
	}
}
