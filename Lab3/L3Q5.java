package Lab3;

import java.util.Scanner;
public class L3Q5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Crammer's rule:");
		System.out.println("ax + by = e, cx + dy = f");
		System.out.println("x = (ed-bf) / (ad-bc) y=(af-ec) / (ad-bc)");
		System.out.println("");
		
		char[] ch = {'a','b','c','d','e','f'};
		int[] values = new int[6];
		
		for(int i = 0; i < 6; i++) {
			System.out.print("Enter the value of " + ch[i] + " : ");
			values[i] = scanner.nextInt();
		}
		
		scanner.close();
		
		int denominator = values[0] * values[3] - values[1] * values[2];
		
		if (denominator == 0) {
			System.out.println("The equation has no solution");
		} else {
			int numeratorX = values[4] * values[3] - values[1] * values[5]; 
			int numeratorY = values[0] * values[5] - values[4] * values[2];	
			int x = numeratorX / denominator;
			int y = numeratorY / denominator;
			
			System.out.printf("The value of x = %d\nThe value of y = %d", x, y);
		}
		
		
	}
}
