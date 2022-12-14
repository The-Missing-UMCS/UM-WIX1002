package com.fyiernzy.Lab7;

import java.io.*;
import java.util.*;

public class L7Q1 {
	public static void main(String[] args) {
		new L7Q1().run();
	}
	
	public void run() {
		generateFile();
		HashMap<String, String> courseList = getCourseList();
		
		Scanner scanner = new Scanner(System.in);
		StringBuilder code = new StringBuilder();
		
		while(true) {
			System.out.print("Enter the course code (enter q to quit): ");
			
			code = code.append(scanner.nextLine());
			
			if (code.charAt(0) == 'q')
				break;
			
			if (courseList.containsKey(code.toString()))
				System.out.printf("Course Code: %s\nCourse Name: %s\n\n", code, courseList.get(code.toString()));
			else
				System.out.println("The course doesn't exist.\n");
			
			code.setLength(0);
		}
		
		scanner.close();
		
	}
	
	public void generateFile() {
		HashMap<String, String> courseList = new HashMap<String, String>();
		
		courseList.put("WXES1116", "Programming I");
		courseList.put("WXES1115", "Data Structure");
		courseList.put("WXES1110", "Operating System");
		courseList.put("WXES1112", "Computing Mathematics I");
		
		try {
			ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("../WIX1002/io_files/coursename.dat"));
			
			for (Map.Entry<String, String> course : courseList.entrySet()) {
				writer.writeObject(String.format("%s,%s", course.getKey(), course.getValue()));
			}
			
			writer.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public HashMap<String, String> getCourseList() {
		HashMap<String, String> courseList = new HashMap<String, String>();
		
		try {
			ObjectInputStream reader = new ObjectInputStream(new FileInputStream("../WIX1002/io_files/coursename.dat"));
			String line = "";
			String[] courseInfo;
			
			while((line = (String) reader.readObject()) != null) {
				courseInfo = line.split(",");
				courseList.put(courseInfo[0], courseInfo[1]);
			}
			
			reader.close();
			
		} catch (EOFException ex) {
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return courseList;
	}
}
