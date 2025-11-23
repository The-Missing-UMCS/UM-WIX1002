package com.umwix1002.solution.pastyear.PastYear2023.Q2;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Q2B {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numOfStudents = promptInt(sc, "Enter the number of students: ", 0, 10);
            int[][] marks = initializeStudentMarks(sc, numOfStudents);

            displayStudentMarks(marks);

            int[] highestAverage = getHighestAverageStudent(marks);
            System.out.printf("Student %d has the highest average, with %d marks%n", highestAverage[0] + 1, highestAverage[1]);
        }
    }

    private static int[][] initializeStudentMarks(Scanner sc, int numOfStudents) {
        int[][] marks = new int[numOfStudents][];

        for (int studentIndex = 0; studentIndex < numOfStudents; studentIndex++) {
            int numOfSubjects = promptInt(sc, String.format("Enter the number of subjects for student %d: ", studentIndex + 1), 0, 10);
            marks[studentIndex] = getStudentMarks(sc, studentIndex, numOfSubjects);
        }

        return marks;
    }

    private static int[] getStudentMarks(Scanner sc, int studentIndex, int numOfSubjects) {
        int[] marks = new int[numOfSubjects + 1];
        int totalMarks = IntStream.range(0, numOfSubjects)
            .map(subjectIndex -> {
                int mark = promptInt(sc, String.format("Student (%d) Enter mark for Subject %d: ", studentIndex + 1, subjectIndex + 1), 0, 100);
                marks[subjectIndex] = mark;
                return mark;
            })
            .sum();

        marks[numOfSubjects] = totalMarks / numOfSubjects;
        return marks;
    }

    private static void displayStudentMarks(int[][] marks) {
        System.out.printf("List of Students (%d students)%n", marks.length);
        for (int studentIndex = 0; studentIndex < marks.length; studentIndex++) {
            System.out.println("Student " + (studentIndex + 1));
            for (int subjectIndex = 0; subjectIndex < marks[studentIndex].length - 1; subjectIndex++) {
                System.out.printf("  Subject %d: %d%n", subjectIndex + 1, marks[studentIndex][subjectIndex]);
            }
            System.out.println("Average Marks: " + marks[studentIndex][marks[studentIndex].length - 1]);
        }
    }

    private static int[] getHighestAverageStudent(int[][] marks) {
        return IntStream.range(0, marks.length)
            // Map to new int[] {studentIndex, average}
            .mapToObj(studentIndex -> new int[]{studentIndex, marks[studentIndex][marks[studentIndex].length - 1]})
            // Find the student with the highest average
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
