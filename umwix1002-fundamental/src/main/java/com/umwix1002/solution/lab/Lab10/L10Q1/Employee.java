package com.umwix1002.solution.lab.Lab10.L10Q1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class Employee {
    protected final String name;

    public abstract String getEmployeeType();

    public abstract double getSalary();

    public void showDetails() {
        System.out.printf("%-13s %-22s %-10.2f\n", getName(), getEmployeeType(), getSalary());
    }
}
