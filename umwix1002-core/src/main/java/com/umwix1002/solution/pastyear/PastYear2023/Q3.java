package com.umwix1002.solution.pastyear.PastYear2023;

import java.util.Scanner;
import java.io.*;

import static com.umwix1002.solution.Properties.PAST_YEAR;

public class Q3 {
	public static void main(String[] args) {
		String inputFile = PAST_YEAR + "PastYear2023/ocean_data.csv";
		DataBuoy[] data = new DataBuoy[25];
		float avg_water_temp;
		
		loadData(inputFile, data);
		showData(data);
		
		avg_water_temp = calculateAvgWaterTemp(data);
		System.out.println("\nAverage water temperature is " + avg_water_temp);
		
		printMap(data, avg_water_temp);
	}
	
	public static void loadData(String inputFile, DataBuoy[] data) {
		int n = data.length;
		try (Scanner sc = new Scanner(new File(inputFile))){
			for(int i = 0; i < n; i++) {
				String[] info = sc.nextLine().split(",");
				data[i] = new DataBuoy(info[0], 
						Integer.parseInt(info[1]), Integer.parseInt(info[2]),
						Double.parseDouble(info[3]), Double.parseDouble(info[4]));
			}
		} catch(FileNotFoundException ex) {
			System.out.println("File not found: " + ex.getMessage());
		}
	}
	
	public static void showData(DataBuoy[] data) {
		System.out.println("Data read from buoy:");
		String format = "%-16s %-8s %-8s %-8s %-8s\n";
		System.out.printf(format, "buoy_id", "lat", "long", "air_t", "water_t");
		for(DataBuoy buoy : data) {
			System.out.printf(format, buoy.getBuoyID(), buoy.getLatitude(), buoy.getLongitude(),
					buoy.getAirT(), buoy.getWaterT());
		}
	}
	
	public static float calculateAvgWaterTemp(DataBuoy[] data) {
		int n = data.length; float sum = 0;
		for(DataBuoy buoy : data)
			sum += (float) buoy.getWaterT();
		return Float.parseFloat(String.format("%.3f", sum / n));
	}
	
	public static void printMap(DataBuoy[] data, double averageWaterTmp) {
		int row = 21, col = 21;
		char[][] map = new char[row][col];
		for(DataBuoy buoy : data) {
			int lat = buoy.getLatitude(), lo = buoy.getLongitude();
			if(buoy.getWaterT() > averageWaterTmp)
				map[lat + 10][lo + 10] = 'H';
			else if(buoy.getWaterT() < averageWaterTmp)
				map[lat + 10][lo + 10] = 'C';
			else 
				map[lat + 10][lo + 10] = 'A';
		}
		
		map[10][10] = 'N';
		
		System.out.println("\nHeat Map of water temperature");
		
		for(int lat = row - 1; lat >= 0; lat--) {
			for(int lo = col - 1; lo >= 0; lo--) {
				if((int) map[lat][lo] == 0)
					System.out.print('~');
				else 
					System.out.print(map[lat][lo]);
			}
			System.out.println();
		}
	}
}
