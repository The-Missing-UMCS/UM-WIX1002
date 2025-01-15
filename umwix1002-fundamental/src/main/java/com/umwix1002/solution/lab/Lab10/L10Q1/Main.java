package com.umwix1002.solution.lab.Lab10.L10Q1;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new PermanentEmployee("Employee 1", 'A');
        employees[1] = new ContractStaff("Employee 2", 1250.30);
        employees[2] = new TemporaryStaff("Employee 3", 70);

        System.out.printf("%-13s %-22s %-10s\n", "Name", "Type", "Salary");
        for (Employee employee : employees) employee.showDetails();
    }
}
