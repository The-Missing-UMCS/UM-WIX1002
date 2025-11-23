package com.umwix1002.solution.pastyear.PastYear2023.Q2;

import com.umwix1002.solution.pastyear.PastYear2023.Q2.domain.Result;
import com.umwix1002.solution.pastyear.PastYear2023.Q2.domain.Student;
import com.umwix1002.solution.pastyear.PastYear2023.Q2.domain.Subject;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Q2C {
    private static final String STUDENT_NUM_PROMPT = "Enter the number of students: ";
    private static final String SUBJECT_PROMPT = "Enter the number of subjects for student %d: ";
    private static final String MARK_PROMPT = "Student (%d) Enter mark for Subject %d: ";
    private static final String DISPLAY_TITLE = "List of Students (%d students)%n";
    private static final String AVERAGE_MARKS = "Average Marks: ";
    private static final String SUBJECT = "  Subject %s: %d%n";
    private static final String STUDENT = "Student ";
    private static final String HIGHEST_AVERAGE = "Student %s has the highest average, with %.2f marks%n";
    private static final int LOW = 0;

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numOfStudents = promptInt(sc, STUDENT_NUM_PROMPT, 0, 10);
            List<Student> students = initializeStudents(sc, numOfStudents);

            displayAllStudentResult(students);

            Student studentWithHighestAverage = getHighestAverageStudent(students);
            System.out.printf(HIGHEST_AVERAGE,
                studentWithHighestAverage.id(), studentWithHighestAverage.result().getAverage());
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
            // 1. Print out student id
            System.out.println(STUDENT + student.id());
            Result result = student.result();

            // 2. Print out all subjects and marks
            result.getSubjects().forEach(subject ->
                System.out.printf(SUBJECT, subject.id(), subject.mark()));

            // 3. Print out average marks
            System.out.println(AVERAGE_MARKS + result.getAverage());
        });
    }

    private static Student getHighestAverageStudent(List<Student> students) {
        return students.stream()
            .max(Comparator.comparingDouble(student -> student.result().getAverage()))
            .orElseThrow();
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
