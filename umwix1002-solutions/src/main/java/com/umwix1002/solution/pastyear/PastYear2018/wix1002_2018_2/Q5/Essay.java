package com.umwix1002.solution.pastyear.PastYear2018.wix1002_2018_2.Q5;

import lombok.Getter;

@Getter
public class Essay extends GradedActivity {
    private final int grammar;
    private final int spelling;
    private final int length;
    private final int content;

    public Essay(int grammar, int spelling, int length, int content) {
        this.grammar = grammar;
        this.spelling = spelling;
        this.length = length;
        this.content = content;
        setScore(grammar + spelling + length + content);
    }

    @Override
    public String toString() {
        return """
            Essay score:
            Grammar: %d
            Spelling: %d
            Length: %d
            Content: %d
            Total Score: %d
            Essay grade: %c
           """.formatted(grammar, spelling, length, content, score, getGrade());
    }
}
