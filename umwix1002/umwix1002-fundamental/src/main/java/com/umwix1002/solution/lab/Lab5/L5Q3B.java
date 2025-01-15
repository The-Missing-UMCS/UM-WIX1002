package Lab5;

import java.util.Random;
import java.util.Scanner;

public class L5Q3B {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number of employee: ");
		int N = scanner.nextInt();
		scanner.close();
		
		System.out.println("");
		System.out.printf("%12s |%6s |%6s |%6s |%6s |%6s |%6s |%6s |%20s\n", 
				"", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun", "Total work Hours");
		
		System.out.printf("%12s |%6s |%6s |%6s |%6s |%6s |%6s |%6s |%20s\n", 
				"-".repeat(12), "-".repeat(6), "-".repeat(6), "-".repeat(6), 
				"-".repeat(6), "-".repeat(6), "-".repeat(6), "-".repeat(6), "-".repeat(20));
		
		for(int i = 0; i < N; i++) {
			new Worker(i + 1).printHours();
			System.out.println("");
		}
	}

}

class Worker {
	int[] hours;
	int number;
	
	Worker(int n) {
		this.hours = new Random().ints(7, 1, 9).toArray();
		this.number = n;
	}
	
	public void printHours() {
		int total = 0;
		
		System.out.printf("Employee %3d ", number, "");
		
		for(int i = 0; i < hours.length; i++) {
			System.out.printf("|%6d ", hours[i]);
			total += hours[i];
		}
		
		System.out.printf("|%20d", total);
	}
}
