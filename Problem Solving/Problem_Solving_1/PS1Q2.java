package com.fyiernzy.ProblemSolving.PS1;

import java.util.Scanner;
public class PS1Q2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		int price = 0; double total = 0;
		
		while(true) {
			System.out.print("Enter the type of durian [Quit] to terminate: ");
			ans.append(scanner.nextLine());
			
			if (ans.toString().equals("Quit"))
				break;
			
			switch(ans.toString()) {
			case "MK" -> price = 25;
			case "HL" -> price = 22;
			case "D24" -> price = 20; 
			case "UM" -> price = 18; 
			}
			
			System.out.print("Enter sales in kg: ");
			total += price * scanner.nextDouble();
			
			ans.setLength(0);
			scanner.nextLine();
		}
		
		System.out.printf("Total sales: %.2f", total);
		scanner.close();
	}
}