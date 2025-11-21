package com.umwix1002.solution.lab.lab09.l9q2.l9q2c;

import org.jetbrains.annotations.NotNull;

public record Course(
    String courseCode,
    String courseName,
    int session,
    int semester,
    int marks
) {

    public String getGrade() {
        return GradeEnum.getByMarks(this.marks).getGrade();
    }

    @Override
    public @NotNull String toString() {
        return "Course{" +
               "courseCode='" + courseCode + '\'' +
               ", courseName='" + courseName + '\'' +
               ", session=" + session +
               ", semester=" + semester +
               ", marks=" + marks +
               ", grade='" + getGrade() + '\'' +
               '}';
    }
}

