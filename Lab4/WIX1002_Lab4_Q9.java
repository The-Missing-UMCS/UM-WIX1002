package Lab4;

import java.util.Scanner;

public class WIX1002_Lab4_Q9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a value: ");
		int num = scanner.nextInt();
		scanner.close();
		
		if (num < 2) {
			System.out.println("No prime number.");
		} else {
			for(int i = 2; i <= num; i++) {
				if (isPrimeNumber(i) == true) {
					System.out.print(i + " ");
				}
			}
		}
	}
	
	public static boolean isPrimeNumber(int num) {
		if (num == 2)
			return true;
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
