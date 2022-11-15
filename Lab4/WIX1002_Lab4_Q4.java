package Lab4;

import java.util.Scanner;

public class WIX1002_Lab4_Q4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter an Integer: ");
		int integer = scanner.nextInt();
		scanner.close();
		
		System.out.print("The factors are: ");
		for(int i = 1; i < integer; i++) {
			if (integer % i == 0) {
				System.out.print(i + ", ");
			}
		}
		System.out.print(integer);
	}
}
