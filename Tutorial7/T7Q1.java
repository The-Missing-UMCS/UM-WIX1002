package com.fyiernzy.Tutorial7;

import java.io.*;

public class T7Q1 {
	public static void main(String[] args) {
		String txtFile = "./io_files/integer.txt";
		String binFile = "./io_files/integer.dat";
		
		storeText(txtFile);
		readText(txtFile);
		
		storeBin(binFile);
		readBin(binFile);
	}
	
	public static void storeText(String file) {
		try {
			PrintWriter writer = new PrintWriter(file);
			
			for(int i = 0; i < 10; i++) 
				writer.println((int) (Math.random() * 1001));
			
			writer.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void readText(String file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = "";
			int num;
			int max = -1;
			
			while((line = reader.readLine()) != null) {
				num = Integer.parseInt(line);
				System.out.print(num + " ");
				
				if (num > max)
					max = num;
			}
			
			reader.close();
			System.out.println("\nLargest number: " + max);
			
			
		} catch (Exception ex) {}
	}
	
	public static void storeBin(String file) {
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
			
			for(int i = 0; i < 10; i++) 
				output.writeInt((int) (Math.random() * 1001));
			
			output.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void readBin(String file) {
		int total = 0, count = 0;
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream(file));
			int num;
			
			while(true) {
				num = input.readInt();	
				System.out.print(num + " ");
				total += num;
				count++;
			}
			
			
		} catch (EOFException ex) {
			System.out.println("");
			System.out.println("The average is " + (total / count));
		}
		
		catch (Exception ex) {}
	}
	
}
