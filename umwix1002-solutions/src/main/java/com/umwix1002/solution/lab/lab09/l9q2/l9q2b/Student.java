package com.umwix1002.solution.lab.lab09.l9q2.l9q2b;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
@ToString(exclude = "courses")
public class Student {

    private String name;
    private Gender gender;
    private String dob;
    private List<Course> courses;
}
