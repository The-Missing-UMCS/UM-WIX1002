package com.umwix1002.solution.problemsolving.ps2223s03.PS3Q5;

public class PartTimeStaff extends Staff {
    private final int workingHour;

    PartTimeStaff(String name, String ic, int hour) {
        super(name, ic);
        this.workingHour = hour;
    }

    @Override
    public double getSalary() {
        return this.workingHour * 40;
    }

    @Override
    public String toString() {
        return """
            %s
            Number of working Hours: %d
            Salary: RM %.0f""".formatted(super.toString(), workingHour, getSalary());
    }
}
