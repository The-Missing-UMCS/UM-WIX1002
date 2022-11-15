package Lab4;

import java.util.Scanner;
public class WIX1002_Lab4_Q2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the value of n: ");
		int n = scanner.nextInt();
		scanner.close();
		int sum = 0, num;
		for(int i = 1; i <= n; i++) {
			num = add(i);
			System.out.print(num + " ");
			sum += num;
		}
		System.out.println("The sum is: " + sum);
	}
	
	public static int add(int n) {
		if (n <= 1) {
			return n;
		} else {
			return (n + add(n-1));
		}
	}
}
