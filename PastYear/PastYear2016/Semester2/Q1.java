package PastYear2016.Semester2;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number is pounds: ");
		double pounds = sc.nextDouble();
		System.out.printf("%s pounds is %.3f kilograms\n\n", pounds, pounds * 0.454);
		sc.close();
		
	}
}
