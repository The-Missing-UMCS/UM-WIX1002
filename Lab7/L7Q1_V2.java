package com.fyiernzy.Lab7;

import java.io.*;
import java.util.*;

public class L7Q1_V2 {
	public static void main(String[] args) {
		String binFile = "../WIX1002/io_files/coursename.dat";
		Scanner scanner = new Scanner(System.in);
		StringBuilder code = new StringBuilder();
		
		generateFile(binFile);
		
		while(true) {
			System.out.print("Enter the course code (enter q to quit): ");
			
			code = code.append(scanner.nextLine());
			
			if (code.charAt(0) == 'q')
				break;	
			
			checkCode(code.toString(), binFile);
			code.setLength(0);
		}
		
		scanner.close();
	}

	
	public static void generateFile(String toFile) {
		try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(toFile))) {
			
			writer.writeObject("WXES1116,Programming I");
			writer.writeObject("WXES1115,Data Structure");
			writer.writeObject("WXES1110,Operating System");
			writer.writeObject("WXES1112,Computing Mathematics I");
			writer.flush();
	
		} catch (Exception ex) { ex.printStackTrace(); }
		
	}
	
	public static void checkCode(String code, String fromFile) {
		try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fromFile))) {
			String[] info;
			do {
				info = ((String) reader.readObject()).split(",");
			} while (!info[0].equals(code));
			
			System.out.printf("Course Code: %s\nCourse Name: %s\n\n", info[0], info[1]);
		}
		
		catch (EOFException ex) { System.out.println("Course not found"); } 
		catch (Exception ex) { }
		
	}

}
