package Lab2;

import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.NumberFormat;
public class L2Q6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		NumberFormat numFormat = new DecimalFormat("0.######E0");
		
		System.out.print("Enter the amount of water in gram: ");
		double waterWeight = scanner.nextDouble() / 1000;

		
		System.out.print("Enter the initial temperature in Fahrenheit: ");
		double tempIni = tempConverter(scanner.nextDouble());

		
		System.out.print("Enter the final temperature in Fahrenheit: ");
		double tempFinal = tempConverter(scanner.nextDouble());

		
		double energy = waterWeight * (tempFinal - tempIni) * 4184;
		
		// Display 1
		System.out.printf("The energy needed is %.6e\n", energy);
		
		// Display 2
		System.out.println("The energy needed is " + numFormat.format(energy));
	}
	
	public static double tempConverter(double fah) {
		return (fah - 32) / 18;
	}
}
