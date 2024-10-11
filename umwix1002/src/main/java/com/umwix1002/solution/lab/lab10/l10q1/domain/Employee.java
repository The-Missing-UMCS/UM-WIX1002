package com.umwix1002.solution.lab.lab10.l10q1.domain;

import com.umwix1002.solution.lab.lab10.l10q1.enums.EmployeeTypeEnum;
import lombok.*;

/**
 * @author Ng Zhi Yang
 */
@ToString
public abstract class Employee {
    
    Employee(EmployeeTypeEnum employeeType, String name) {
        this.employeeType = employeeType;
        this.name = name;
        this.salary = Double.NaN;
    }
    
    @Getter
    protected final EmployeeTypeEnum employeeType;
    
    @Getter @Setter
    protected String name;
    
    protected Double salary;
    
    abstract Double getSalary();
}
