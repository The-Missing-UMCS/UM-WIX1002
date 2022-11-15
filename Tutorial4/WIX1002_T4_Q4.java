package Tutorial4;

import java.util.Scanner;

public class WIX1002_T4_Q4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your sentence: ");
		String str = scanner.nextLine();
		scanner.close();
		
		for(int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
	}
}
