package com.fyiernzy.ProblemSolving.PS3;

import java.io.*;
// import javax.swing.JFileChooser;

public class PS3Q4 {
	public static void main(String[] args) {
		// Other way of choosing a file
		
		/*
		String binFilePath = "";
		try {
			JFileChooser chooser = new JFileChooser("./");
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.showOpenDialog(null);
			binFilePath = chooser.getSelectedFile().getAbsolutePath() + "\\Q4.dat";
		} catch (Exception ex) {
			binFilePath = "./src/com/fyiernzy/ProblemSolving/PS3/io_files/Q4.dat";
		}
		 */

		String binFilePath = "./src/com/fyiernzy/ProblemSolving/PS3/io_files/Q4.dat";
		
		writeBinaryFile(binFilePath);
		
		try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(binFilePath))){
			while(true) {
				new DayOfTheWeek(input.readInt(), input.readInt(), input.readInt()).showDayOfWeek();;
			}
		} 
		catch (EOFException ex) { } 
		catch (Exception ex) { ex.printStackTrace(); }
	}
	
	public static void writeBinaryFile(String file) {
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))){
			// Each record in the binary file contains q, m and y in order
			output.writeInt(25); output.writeInt(3); output.writeInt(2017);
			output.writeInt(29); output.writeInt(2); output.writeInt(2100);
			output.writeInt(19); output.writeInt(1); output.writeInt(2017);
			output.writeInt(31); output.writeInt(9); output.writeInt(2015);
			output.writeInt(31); output.writeInt(5); output.writeInt(2017);
			output.writeInt(29); output.writeInt(2); output.writeInt(2016);
		} catch (Exception ex) { ex.printStackTrace(); }
	}
}

class DayOfTheWeek {
	// Add value = 0 at index = 0 to avoid IndexOutOfBoundException
	int[] dayOfMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
	
	// Day of the week in Zeller’s congruence
	static final String[] DAY_OF_WEEK = {"Saturday", "Sunday", "Monday", "Tuesday", 
			"Wednesday", "Thursday", "Friday"};
	int h, q, m, y, j, k;
	
	
	DayOfTheWeek(int dayOfMonth, int month, int year) {
		this.q = dayOfMonth;
		this.m = month;
		this.y = year;
		
		if (this.m == 1 || this.m == 2) { // January and February are counted as 13 and 14 of the previous year
			this.m += 12;
			this.y--;
		}
		
		this.k = this.y % 100;
		this.j = this.y / 100;
		
		this.h = (q + (13 * (this.m + 1) / 5) + k + (k / 4) + (j / 4) + 5 * j) % 7;
		
		if (this.m == 13 || this.m == 14) { // Restore the value of m and y
			this.m -= 12;
			this.y++;
		}
	}
	
	public boolean isLeapYear() {
		return ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0);
	}

	public int getDayOfWeek() {
		return this.h;
	}
	
	public boolean isValidDate() {
		if (isLeapYear())
			dayOfMonth[2] = 29; 
		
		return (this.q <= dayOfMonth[m]);
	}
	
	public void showDayOfWeek() {
		System.out.printf("%d/%d/%d is %s\n", q, m, y, 
				(isValidDate() ? ("on " + DAY_OF_WEEK[h]) : "invalid Input"));
	}

	
}