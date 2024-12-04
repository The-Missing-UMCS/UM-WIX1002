package com.umwix1002.solution.lab.lab10.l10q1.domain;

import com.umwix1002.solution.lab.lab10.l10q1.enums.EmployeeTypeEnum;
import com.umwix1002.solution.lab.lab10.l10q1.helper.SalaryFacade;
import lombok.*;

/**
 * @author Ng Zhi Yang
 */
@Getter
@Setter
public abstract class Employee {
    protected String name;

    Employee(String name) {
        this.name = name;
    }
    
    public Double getSalary() {
        return SalaryFacade.calculate(this);
    }

    public abstract EmployeeTypeEnum getEmployeeType();

    @Override
    public String toString() {
        return "Employee{employeeType=%s,name='%s',salary=%s}".formatted(getEmployeeType(), name, getSalary());
    }
}
