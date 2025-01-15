package Lab4;

import java.util.Scanner;
public class L4Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, sum = 0;
		System.out.print("Enter the value of n: ");
		n = sc.nextInt();
		sc.close();
		sum = 0;
		for(int i = 1; i <= n; i++) 
			// sum += add(i);
			for(int j = 1; j <= i; j++) 
				sum += j;
		System.out.println("The sum is: " + sum);
	}
	
	public static int add(int n) {
		return n < 2 ? n : n + add(n - 1);
	}
}
