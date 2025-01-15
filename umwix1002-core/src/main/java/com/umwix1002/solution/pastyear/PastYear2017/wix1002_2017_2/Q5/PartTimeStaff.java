package com.umwix1002.solution.pastyear.PastYear2017.wix1002_2017_2.Q5;

public class PartTimeStaff extends Staff {
    private static final int RATE = 40;
    private final int workingHours;

    public PartTimeStaff(String name, String ic, int workingHours) {
        super(name, ic);
        this.workingHours = workingHours;
    }

    public int getSalary() {
        return RATE * workingHours;
    }

    @Override
    public String toString() {
        return """
            %s
            Number of working hours: %d
            Salary: RM %d""".formatted(super.toString(), workingHours, getSalary());
    }

}
