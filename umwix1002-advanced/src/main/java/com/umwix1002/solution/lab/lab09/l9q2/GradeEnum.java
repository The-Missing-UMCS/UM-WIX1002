package com.umwix1002.solution.lab.lab09.l9q2;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter(AccessLevel.PUBLIC)
@RequiredArgsConstructor
public enum GradeEnum {
    A(85, "A"),
    A_MINUS(80, "A-"),
    B_PLUS(75, "B+"),
    B(70, "B"),
    B_MINUS(65, "B-"),
    C_PLUS(60, "C+"),
    C(55, "C"),
    D(50, "D"),
    E(40, "E"),
    F(0, "F");
    
    private final int requiredMarks;
    private final String grade;
    
    public static GradeEnum getByMarks(int marks) {
        return Arrays.stream(GradeEnum.values())
            .filter(gradeEnum -> marks >= gradeEnum.getRequiredMarks())
            .findFirst()
            .orElse(F);
    }

}
