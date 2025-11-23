package com.umwix1002.solution.problemsolving.ps2223s03.PS3Q5;

public class PermanentStaff extends Staff {
    private final String grade;

    PermanentStaff(String name, String ic, String grade) {
        super(name, ic);
        this.grade = grade;
    }

    @Override
    public double getSalary() {
        return switch (grade) {
            case "EM01" -> 7000;
            case "EM02" -> 5000;
            case "EM03" -> 3000;
            case "EM04" -> 1000;
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return """
            %s
            Grade: %s
            Salary: RM %.0f""".formatted(super.toString(), grade, getSalary());
    }
}
