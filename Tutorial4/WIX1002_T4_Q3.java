package Tutorial4;

import java.util.Scanner;
public class WIX1002_T4_Q3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter value of n = ");
		int n = scanner.nextInt();
		scanner.close();
		for(int i = 0; i < n; i++)
			System.out.print(fibonacci(i) + " ");
		
	}
	
	public static int fibonacci(int n) {
		if (n == 1 || n == 0) {
			return n;
		} else {
			return (fibonacci(n-1) + fibonacci(n-2));
		}
	}
	
}
