package Lab7.L7Q1;

import java.io.*;
import java.util.*;

import Lab7.Generator;

public class L7Q1C {
	public static void main(String[] args) {
		Map<String, String> courseList = getCourseList(Generator.COURSE_FILE);
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.print("Enter the course code (enter q to quit): ");
			String courseCode = scanner.nextLine();
			
			if (courseCode.charAt(0) == 'q') break;
			
			if (courseList.containsKey(courseCode))
				System.out.printf("Course Code: %s\nCourse Name: %s\n\n", courseCode, courseList.get(courseCode));
			else
				System.out.println("The course doesn't exist.\n");
		}
		
		scanner.close();
	}
	
	/*
	 * Read the file and return the HashMap.
	 */
	public static Map<String, String> getCourseList(String fromFile) {
		var courseList = new HashMap<String, String>();
		try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(fromFile))) {
			String line;
			while((line = (String) reader.readObject()) != null) {
				String[] courseInfo = line.split(",");
				courseList.put(courseInfo[0], courseInfo[1]);
			}

		} catch (Exception ex) {}
		
		return courseList;
	}
}
