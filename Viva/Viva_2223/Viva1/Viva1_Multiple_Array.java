package com.fyiernzy.Viva.Viva1;

import java.util.stream.DoubleStream;

public class Viva1_Multiple_Array {
	public static void main(String[] args) {
		String[] names = {"Ali","Beng","Carmen","Dinesh","Emilia"};
		String[] regNo = {"s12345","s24567","s23789","s14569","s18743"};
		double[] marks = {77.9, 33.1, 90.3, 60.5, 40.7};
		int[] index = {0, 1, 2, 3, 4};
		
		double total = 0;
		for(double i : marks) {
			total += i;
		}
		
		double average = total / marks.length;
		// DoubleStream.of(marks).average().getAsDouble();
		
		System.out.println(" Original Data:");
		System.out.printf(" %-10s %-10s %-11s\n", "Reg No.", "Name", "FOP Marks");
		System.out.println(" +" + "-".repeat(30) + "+");
		for(int i : index)
			System.out.printf(" %-10s %-10s %-11.1f\n", regNo[i], names[i], marks[i]);
		
		System.out.printf("\n Average marks is:\t%.2f\n", average);
			
		// Sort by marks
		boolean isSwap = true;
		for(int i = 0; i < names.length; i++) {
			isSwap = false;

			for(int j = 0; j < names.length - i - 1; j++) {
				if (marks[index[j]] < marks[index[j+1]]) {
					int tmp = index[j];
					index[j] = index[j+1];
					index[j+1] = tmp;
				}
				
				isSwap = true;
			}
			
			if (!isSwap) {
				break;
			}
		}
	
		System.out.println("\n Sorted Data (by Marks):");
		System.out.printf(" %-10s %-10s %-11s %-10s\n", "Reg No.", "Name", "FOP Marks", "Average");
		System.out.println(" +" + "-".repeat(40) + "+");
		for(int i : index)
			System.out.printf(" %-10s %-10s %-11.1f %-10s\n", regNo[i], names[i], marks[i], checkAverage(marks[i], average));
	}
	
	public static String checkAverage(double marks, double average) {
		if (marks > average)
			return "ABOVE";
		else if (marks == average)
			return "AVERAGE";
		else
			return "BELOW";
	}
}
