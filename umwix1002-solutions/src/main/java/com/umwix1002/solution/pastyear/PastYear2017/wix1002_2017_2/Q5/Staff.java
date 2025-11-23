package com.umwix1002.solution.pastyear.PastYear2017.wix1002_2017_2.Q5;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Staff {
    private String name;
    private String ic;

    @Override
    public String toString() {
        return """
            Full Name: %s
            IC: %s""".formatted(name, ic);
    }
}
