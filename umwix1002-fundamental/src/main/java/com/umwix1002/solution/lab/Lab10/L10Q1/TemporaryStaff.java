package com.umwix1002.solution.lab.Lab10.L10Q1;

public class TemporaryStaff extends Employee {
    private static final int PAY_RATE = 15;
    private final double totalHour;

    TemporaryStaff(String name, double totalHour) {
        super(name);
        this.totalHour = totalHour;
    }

    @Override
    public String getEmployeeType() {
        return "Contract Staff";
    }

    @Override
    public double getSalary() {
        return PAY_RATE * this.totalHour;
    }
}
