package com.umwix1002.solution.lab.lab07.l7q1;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.umwix1002.solution.Properties.*;

public class l7q1b {

    private static final String COURSE_FILE = chainDir(LAB7, IO_FILES, "coursename.dat");

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Course> courses = readSources();
            while (true) {
                System.out.print("Enter the course code (enter q to quit): ");
                String courseCode = scanner.nextLine();

                if (courseCode.charAt(0) == 'q') {
                    break;
                }

                Course course = findCourse(courses, courseCode);
                if (course != null) {
                    System.out.printf("Course Code: %s%nCourse Name: %s%n%n",
                        course.code(), course.name());
                } else {
                    System.out.println("The course doesn't exist.%n");
                }
            }
        }
    }

    private static Course findCourse(List<Course> courseList, String courseCode) {
        for (Course course : courseList) {
            if (course.code().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    private static List<Course> readSources() throws Exception {
        List<Course> courseList = new ArrayList<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(COURSE_FILE))) {
            String line;
            while ((line = (String) reader.readObject()) != null) {
                String[] courseInfo = line.split(",");
                String courseCode = courseInfo[0];
                String courseName = courseInfo[1];
                courseList.add(new Course(courseCode, courseName));
            }
        }
        return courseList;
    }

    record Course(
        String code,
        String name
    ) {

    }
}
