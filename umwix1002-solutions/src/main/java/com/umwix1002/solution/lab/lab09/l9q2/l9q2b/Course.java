package com.umwix1002.solution.lab.lab09.l9q2.l9q2b;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class Course {

    private String courseCode;
    private String courseName;
    private int session;
    private int semester;
    private int marks;

    public String getGrade() {
        return GradeEnum.getByMarks(this.marks).getGrade();
    }

    @Override
    public String toString() {
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
