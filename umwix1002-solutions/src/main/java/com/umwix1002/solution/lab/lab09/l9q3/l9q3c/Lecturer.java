package com.umwix1002.solution.lab.lab09.l9q3.l9q3c;

import com.umwix1002.solution.lab.lab09.l9q2.l9q2c.Gender;

import java.util.List;

public record Lecturer(
    String name,
    Gender gender,
    String dob,
    List<Lecture> lectures
) {

}
