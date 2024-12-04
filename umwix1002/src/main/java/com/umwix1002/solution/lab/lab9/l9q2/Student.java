package com.umwix1002.solution.lab.lab9.l9q2;

import com.umwix1002.solution.lab.lab7.helper.Gender;
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
