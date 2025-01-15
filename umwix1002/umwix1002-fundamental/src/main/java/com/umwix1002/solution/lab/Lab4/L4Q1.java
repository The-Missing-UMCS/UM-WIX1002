package Lab4;

import java.util.Scanner;

public class L4Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter an Integer: ");
		int n = sc.nextInt(); sc.close();
		System.out.print("The factors are: ");
		for(int i = 1; i < n; i++) 
			if (n % i == 0)
				System.out.print(i + ", ");
		System.out.print(n);
	}
}
