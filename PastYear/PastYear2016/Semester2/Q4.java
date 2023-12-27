package PastYear2016.Semester2;

import static java.lang.Math.*;
public class Q4 {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.print("Enter the value of n for a regular polygon, n: ");
		int n = sc.nextInt();
		System.out.print("Enter the length of a particular side of the regular polygon (in meter), s: ");
		int s = sc.nextInt();
		System.out.printf("The area is: %.2f squared meters.", area(n, s));
		sc.close();
	}
	
	public static double area(int n, double s) {
		return (n * pow(s, 2)) / (4 * tan(toRadians(180 / n)));
	}
}
