package com.umwix1002.solution.lab.lab09.l9q3.l9q3c;

public record Lecture(
    String courseCode,
    String courseName,
    int session,
    int semester,
    double creditHour,
    int studentCount
) {

    public double getCreditHour() {
        return creditHour * CreditHour.getCreditHourByStudentCount(studentCount).getMultiplier();
    }
}
