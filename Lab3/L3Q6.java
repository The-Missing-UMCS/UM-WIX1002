package Lab3;

import java.util.Scanner;

public class L3Q6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the radius: ");
		int radius = scanner.nextInt();
		System.out.print("Enter the coordinate (4 5) : ");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		scanner.close();
		
		int squareX = (int)(Math.pow(x, 2));
		int squareY = (int)(Math.pow(y, 2));
		double dist = Math.pow(squareX + squareY, 1 / 2);
		
		String ans = "";
		if (dist > radius)
			ans = "outside";
		else if (dist == radius)
			ans = "on";
		else 
			ans = "inside";
		
		System.out.println("The point is " + ans + " the circle");
	}
}
