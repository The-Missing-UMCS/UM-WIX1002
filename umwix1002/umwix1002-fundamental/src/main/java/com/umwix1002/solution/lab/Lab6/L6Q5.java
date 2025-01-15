package Lab6;

import java.util.Scanner;

public class L6Q5 {
	public static void main(String[] args) {
		int x, y, z, points = 0;
		Scanner scanner = new Scanner(System.in);
		
		 do {
			System.out.println("Enter negative number to quit.");
			x = (int)(Math.random() * 13);
			y = (int)(Math.random() * 13);
			System.out.printf("%d X %d = ", x, y);
			z = scanner.nextInt();
			
			if (z < 0) break;
			if (check(x, y, z)) points++;
			
		} while(true);
		
		scanner.close();
		System.out.printf("Your score is %d", points);
	}
	
	public static boolean check(int x, int y, int z) {
		return x * y == z;
	}
}
