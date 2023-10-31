package Lab3;

import java.util.Scanner;

public class L3Q6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r, x, y; double dist;
		System.out.print("Enter the radius: ");
		r = sc.nextInt();
		System.out.print("Enter the coordinate (4 5) : ");
		x = sc.nextInt(); y = sc.nextInt(); sc.close();
		dist = Math.sqrt(x * x + y * y);
		System.out.println(dist > r ? "Outside" : "Inside");
	}
}
