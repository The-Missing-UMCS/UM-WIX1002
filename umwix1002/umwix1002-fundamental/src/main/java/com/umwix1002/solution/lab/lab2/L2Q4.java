package Lab2;

import java.util.Scanner;

public class L2Q4 {
	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		long seconds, minutes, hours;
		System.out.print("Enter the time in seconds: ");
		long secondInput = scanner.nextLong();
		scanner.close();
		
		// Solution 1
		seconds = secondInput % 60;
		minutes = (long)(Math.floorDiv(secondInput, 60));
		hours = (long)(Math.floorDiv(minutes, 60));
		minutes -= hours * 60;
		System.out.printf("%d seconds is %d hours %d minutes %d seconds", secondInput, hours, minutes, seconds);
		
		System.out.println("");
		
		// Solution 2
		seconds = secondInput % 60;
		minutes = (long)(Math.floorDiv(secondInput % (60 * 60), 60));
		hours = (long)(Math.floorDiv(secondInput, 60 * 60));
		
		System.out.printf("%d seconds is %d hours %d minutes %d seconds", secondInput, hours, minutes, seconds);
	}
}
