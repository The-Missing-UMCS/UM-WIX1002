package com.umwix1002.solution.lab.lab10.l10q1;

import com.umwix1002.solution.lab.lab10.l10q1.domain.ContractStaff;
import com.umwix1002.solution.lab.lab10.l10q1.domain.Employee;
import com.umwix1002.solution.lab.lab10.l10q1.domain.PermanentEmployee;
import com.umwix1002.solution.lab.lab10.l10q1.domain.TemporaryStaff;

import java.util.List;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new PermanentEmployee("Employee 1", 'A'),
            new ContractStaff("Employee 2", 300),
            new TemporaryStaff("Employee 3", 100)
        );
        
        employees.forEach(System.out::println);
    }
}
