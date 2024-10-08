package com.umwix1002.solution.lab.lab7;

import com.umwix1002.solution.lab.CommonConstant;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Get the .dat file from Spectrum. The current one is malformed.
 */
public class l7q1 {
    private static final String COURSE_FILE = "src/main/java/com/umwix1002/solution/lab/lab7/io_files/coursename.dat";

    public static void main(String[] args) throws IOException {
        Map<String, String> courseList = getCourseList(COURSE_FILE);
        System.out.println(courseList);
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter the course code (enter q to quit): ");
                String courseCode = scanner.nextLine();
                if (courseCode.charAt(0) == 'q') {
                    break;
                }
                if (courseList.containsKey(courseCode)) {
                    System.out.printf("Course Code: %s\nCourse Name: %s\n\n", courseCode, courseList.get(courseCode));
                } else {
                    System.out.println("The course doesn't exist.\n");
                }
            }
        }
    }

    public static Map<String, String> getCourseList(String fromFile) throws IOException {
        try (var lines = Files.lines(Path.of(fromFile))) {
            return lines
                .map(line -> line.split(CommonConstant.COMMA))
                .filter(courseInfo -> courseInfo.length == CommonConstant.TWO)
                .collect(Collectors.toMap(courseInfo -> courseInfo[0], courseInfo -> courseInfo[1]));
        }
    }


}
