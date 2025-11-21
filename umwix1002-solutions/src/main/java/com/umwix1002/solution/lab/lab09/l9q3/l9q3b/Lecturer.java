package com.umwix1002.solution.lab.lab09.l9q3.l9q3b;

import com.umwix1002.solution.lab.lab09.l9q2.l9q2b.Gender;
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
