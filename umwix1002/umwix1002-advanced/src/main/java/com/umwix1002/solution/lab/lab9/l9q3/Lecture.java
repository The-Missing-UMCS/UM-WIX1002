package com.umwix1002.solution.lab.lab9.l9q3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class Lecture {
    private String courseCode;
    private String courseName;
    private int session;
    private int semester;
    private double creditHour;
    private int studentCount;
    
    public double getCreditHour() {
        return creditHour * CreditHour.getCreditHourByStudentCount(studentCount).getMultiplier();
    }
}
