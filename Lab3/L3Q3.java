package Lab3;

import java.util.Scanner;

public class L3Q3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double commission = 0;
		System.out.print("Enter the sales volume: ");
		int salesVolume = scanner.nextInt();
		scanner.close();
		if (salesVolume > 1000)
			commission = 0.125;
		else if (salesVolume <= 1000 && salesVolume > 500)
			commission = 0.10;
		else if (salesVolume <= 500 && salesVolume > 100)
			commission = 0.075;
		else 
			commission = 0.05;
		
		System.out.printf("The commission is %.2f", commission);
	}
}
