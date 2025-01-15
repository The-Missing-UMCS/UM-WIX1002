package com.umwix1002.solution.problemsolving.Problem_Solving_3.PS3Q5;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Staff {
    protected final String name;
    protected final String ic;

    @Override
    public String toString() {
        return """
            Name: %s
            IC: %s""".formatted(name, ic);
    }

    public abstract double getSalary();
}
