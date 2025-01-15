package com.umwix1002.solution.lab.Lab10.L10Q1;

public class PermanentEmployee extends Employee {
    private final char category;

    PermanentEmployee(String name, char category) {
        super(name);
        this.category = category;
    }

    @Override
    public String getEmployeeType() {
        return "Permanent Employee";
    }

    @Override
    public double getSalary() {
        return switch (this.category) {
            case 'A' -> 4000;
            case 'B' -> 3000;
            case 'C' -> 2000;
            default -> 0;
        };
    }
}
