package com.umwix1002.solution.lab.Lab7.L7Q1;

import com.umwix1002.solution.lab.Lab7.Generator;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Nullable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L7Q1B {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Course> courseList = getCourseList();
            while (true) {
                System.out.print("Enter the course code (enter q to quit): ");
                String courseCode = scanner.nextLine();

                if (courseCode.charAt(0) == 'q') break;

                Course course = findCourse(courseList, courseCode);
                if (course != null) {
                    System.out.printf("Course Code: %s\nCourse Name: %s\n\n", course.courseCode(), course.courseName());
                } else {
                    System.out.println("The course doesn't exist.\n");
                }
            }
        }
    }

    private static @Nullable Course findCourse(List<Course> courseList, String courseCode) {
        for (Course course : courseList) {
            if (course.courseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    @SneakyThrows
    private static List<Course> getCourseList() {
        List<Course> courseList = new ArrayList<>();
        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(Generator.COURSE_FILE))) {
            String line;
            while ((line = (String) reader.readObject()) != null) {
                String[] courseInfo = line.split(",");
                courseList.add(new Course(courseInfo[0], courseInfo[1]));
            }
        }
        return courseList;
    }
}
