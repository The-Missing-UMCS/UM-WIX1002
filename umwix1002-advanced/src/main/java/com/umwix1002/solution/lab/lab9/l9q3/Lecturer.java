package com.umwix1002.solution.lab.lab9.l9q3;

import com.umwix1002.solution.lab.lab7.helper.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class Lecturer {
    private String name;
    private Gender gender;
    private String dob;
    List<Lecture> lectures;
}
