package Lab7.L7Q1;

import java.io.*;
import java.util.*;

import Lab7.Generator;

public class L7Q1A {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder code = new StringBuilder();
		
		while(true) {
			System.out.print("Enter the course code (enter q to quit): ");
			code = code.append(scanner.nextLine());
			
			if (code.charAt(0) == 'q')
				break;	
			
			checkCode(code.toString(), Generator.COURSE_FILE);
			code.setLength(0);
		}
		
		scanner.close();
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
