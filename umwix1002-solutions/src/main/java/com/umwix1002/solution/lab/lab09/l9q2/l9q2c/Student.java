package com.umwix1002.solution.lab.lab09.l9q2.l9q2c;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public record Student(
    String name,
    Gender gender,
    String dob,
    List<Course> courses
) {

    @Override
    public @NotNull String toString() {
        return String.format("Student{name='%s', gender=%s, dob='%s'}", name, gender, dob);
    }
}

