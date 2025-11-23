package com.umwix1002.solution.lab.lab07.l7q1;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

import static com.umwix1002.solution.Properties.*;


public class l7q1a {

    private static final String COURSE_FILE = chainDir(LAB7, IO_FILES, "coursename.dat");

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            String code;
            while (true) {
                System.out.print("Enter the course code (enter q to quit): ");
                code = scanner.nextLine();

                if (code.charAt(0) == 'q') {
                    break;
                }

                String[] course = findCourseByCode(code);
                if (course != null && course.length > 2) {
                    String courseCode = course[0];
                    String courseName = course[1];
                    System.out.printf("Course Code: %s%nCourse Name: %s%n%n",
                        courseCode, courseName);
                } else {
                    System.out.println("Course not found");
                }
            }
        }
    }

    public static String[] findCourseByCode(String code) throws Exception {
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(COURSE_FILE))) {
            String[] info;
            do {
                info = ((String) reader.readObject()).split(",");
            } while (!info[0].equals(code));
            return info;
        } catch (EOFException ex) {
            return new String[0];
        }
    }
}
