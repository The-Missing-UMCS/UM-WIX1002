package com.umwix1002.solution.lab.Lab7.L7Q1;

import com.umwix1002.solution.lab.Lab7.Generator;
import lombok.SneakyThrows;

import java.io.*;
import java.util.*;

public class L7Q1C {
	public static void main(String[] args) {
		Map<String, String> courseList = getCourseList();

		try(Scanner scanner = new Scanner(System.in)) {
			while(true) {
				System.out.print("Enter the course code (enter q to quit): ");
				String courseCode = scanner.nextLine();

				if (courseCode.charAt(0) == 'q') break;

				if (courseList.containsKey(courseCode))
					System.out.printf("Course Code: %s\nCourse Name: %s\n\n", courseCode, courseList.get(courseCode));
				else
					System.out.println("The course doesn't exist.\n");
			}
		}
	}

	@SneakyThrows
	private static Map<String, String> getCourseList() {
		var courseList = new HashMap<String, String>();
		try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Generator.COURSE_FILE))) {
			String line;
			while((line = (String) reader.readObject()) != null) {
				String[] courseInfo = line.split(",");
				courseList.put(courseInfo[0], courseInfo[1]);
			}

		}
		return courseList;
	}
}
