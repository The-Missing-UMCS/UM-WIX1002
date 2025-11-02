package com.umwix1002.solution.lab.lab07;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.umwix1002.solution.lab.Properties.*;
import static com.umwix1002.solution.lab.constants.CommonConstant.ZERO;

/**
 * Get the .dat file from Spectrum. The current one is malformed.
 *
 * @author Ng Zhi Yang
 */
public class l7q1c {
    private static final String COURSE_FILE = chainDir(LAB7, IO_FILES, "coursename.dat");

    public static void main(String[] args) throws Exception {
        Map<String, String> courses = readCourses();
        System.out.println(courses);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter the course code (enter q to quit): ");
                String courseCode = scanner.nextLine();
                if (courseCode.charAt(ZERO) == 'q') {
                    break;
                }
                if (courses.containsKey(courseCode)) {
                    System.out.printf("Course Code: %s%nCourse Name: %s%n%n", courseCode, courses.get(courseCode));
                } else {
                    System.out.println("The course doesn't exist.%n");
                }
            }
        }
    }

    public static Map<String, String> readCourses() throws Exception {
        Map<String, String> courses = new HashMap<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(COURSE_FILE))) {
            String line;
            while ((line = (String) reader.readObject()) != null) {
                String[] courseInfo = line.split(",");
                String courseCode = courseInfo[0];
                String courseName = courseInfo[1];
                courses.put(courseCode, courseName);
            }
        }
        return courses;
    }
}
