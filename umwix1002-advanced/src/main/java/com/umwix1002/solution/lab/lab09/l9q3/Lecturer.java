package com.umwix1002.solution.lab.lab09.l9q3;

import com.umwix1002.solution.lab.lab07.helper.Gender;
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
