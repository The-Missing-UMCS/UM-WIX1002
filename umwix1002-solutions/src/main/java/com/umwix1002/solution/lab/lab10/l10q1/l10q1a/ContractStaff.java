package com.umwix1002.solution.lab.lab10.l10q1.l10q1a;

public class ContractStaff extends Employee {
    private static final int INCOME = 500;
    private final double totalSales;

    ContractStaff(String name, double totalSales) {
        super(name);
        this.totalSales = totalSales;
    }

    @Override
    public String getEmployeeType() {
        return "Contract Staff";
    }

    @Override
    public double getSalary() {
        return INCOME + totalSales * 0.5;
    }
}
