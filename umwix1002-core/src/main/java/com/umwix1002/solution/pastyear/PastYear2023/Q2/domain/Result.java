package com.umwix1002.solution.pastyear.PastYear2023.Q2.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Result {
    private final List<Subject> subjects = new ArrayList<>();

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public double getAverage() {
        return subjects.stream()
            .mapToInt(Subject::mark)
            .average().orElseThrow();
    }

    public int getTotalMarks() {
        return subjects.stream()
            .mapToInt(Subject::mark)
            .sum();
    }

    public int getNumOfSubjects() {
        return subjects.size();
    }
}
