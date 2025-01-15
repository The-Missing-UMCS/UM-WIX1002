package com.umwix1002.solution.pastyear.PastYear2017.wix1002_2017_2.Q5;

public enum GradeEnum {
    EM01("EM01", 7000),
    EM02("EM02", 5000),
    EM03("EM03", 3000),
    EM04("EM04", 1000);

    private final String grade;
    private final int salary;

    GradeEnum(String grade, int salary) {
        this.grade = grade;
        this.salary = salary;
    }

    public String getGrade() {
        return grade;
    }

    public int getSalary() {
        return salary;
    }
}

