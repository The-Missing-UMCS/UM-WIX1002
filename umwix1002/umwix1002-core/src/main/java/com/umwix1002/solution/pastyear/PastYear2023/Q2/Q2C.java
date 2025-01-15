package com.umwix1002.solution.pastyear.PastYear2023;

import com.umwix1002.solution.pastyear.PastYear2023.domain.Result;
import com.umwix1002.solution.pastyear.PastYear2023.domain.Student;
import com.umwix1002.solution.pastyear.PastYear2023.domain.Subject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Q2C {

    public static final String SUBJECT_PROMPT = "Enter the number of subjects for student %d: ";
    public static final String MARK_PROMPT = "Student (%d) Enter mark for Subject %d: ";
    public static final String DISPLAY_TITLE = "List of Students (%d students)%n";
    public static final String AVERAGE_MARKS = "Average Marks: ";
    public static final int LOW = 0;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numOfStudents = promptInt(sc, "Enter the number of students: ", 0, 10);
            List<Student> students = initializeStudents(sc, numOfStudents);

            displayAllStudentResult(marks);

            int[] highestAverage = getHighestAverageStudent(marks);
            System.out.printf("Student %d has the highest average, with %d marks%n", highestAverage[0] + 1, highestAverage[1]);
        }
    }

    private static List<Student> initializeStudents(Scanner sc, int numOfStudents) {
        List<Student> students = new ArrayList<>(numOfStudents);

        for (int studentIndex = 0; studentIndex < numOfStudents; studentIndex++) {
            int numOfSubjects = promptInt(sc, String.format(SUBJECT_PROMPT, studentIndex + 1), LOW, 10);
            Result result = getStudentResult(sc, studentIndex, numOfSubjects);
            students.add(new Student(getId(studentIndex), result));
        }

        return students;
    }

    private static Result getStudentResult(Scanner sc, int studentIndex, int numOfSubjects) {
        Result result = new Result();
        IntStream.range(0, numOfSubjects)
            .forEach(subjectIndex -> {
                int mark = promptInt(sc, String.format(MARK_PROMPT, studentIndex + 1, subjectIndex + 1), LOW, 100);
                result.addSubject(new Subject(getId(subjectIndex), mark));
            });
        return result;
    }

    private static @NotNull String getId(int subjectIndex) {
        return String.valueOf(subjectIndex + 1);
    }

    private static void displayAllStudentResult(List<Student> students) {
        System.out.printf(DISPLAY_TITLE, students.size());
        students.forEach(student -> {
            System.out.println("Student " + student.id());
            Result result = student.result();
            result.getSubjects().forEach(subject ->
                System.out.printf("  Subject %s: %d%n", subject.id(), subject.mark()));
            System.out.println(AVERAGE_MARKS + result.getAverage());
        });
    }

    private static int[] getHighestAverageStudent(int[][] marks) {
        return IntStream.range(0, marks.length)
            .mapToObj(studentIndex -> new int[]{studentIndex, marks[studentIndex][marks[studentIndex].length - 1]})
            .max(Comparator.comparingInt(student -> student[1]))
            .orElse(new int[]{0, 0});
    }

    private static int promptInt(Scanner sc, String message, int low, int high) {
        int value;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                value = sc.nextInt();
                if (value >= low && value <= high) {
                    return value;
                }
            } else {
                sc.next(); // Clear invalid input
            }
            System.out.print("Error!!!");
        }
    }
}
