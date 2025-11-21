package com.umwix1002.solution.lab.lab10.l10q1.l10q1b;

import java.util.List;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            PermanentEmployee.of("Employee 1", 'A'),
            ContractStaff.of("Employee 2", 300),
            TemporaryStaff.of("Employee 3", 100)
        );
        employees.forEach(System.out::println);
    }
}
