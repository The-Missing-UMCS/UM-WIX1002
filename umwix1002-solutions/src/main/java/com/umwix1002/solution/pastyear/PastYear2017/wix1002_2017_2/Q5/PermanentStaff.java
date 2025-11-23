package com.umwix1002.solution.pastyear.PastYear2017.wix1002_2017_2.Q5;

public class PermanentStaff extends Staff {
    private final GradeEnum grade;

    public PermanentStaff(String name, String ic, GradeEnum grade) {
        super(name, ic);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return """
            %s
            Grade: %s
            Salary: RM %d""".formatted(super.toString(), grade.getGrade(), grade.getSalary());
    }
}