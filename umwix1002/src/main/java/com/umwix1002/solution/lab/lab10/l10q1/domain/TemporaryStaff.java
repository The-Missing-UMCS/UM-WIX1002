package com.umwix1002.solution.lab.lab10.l10q1.domain;

import com.umwix1002.solution.lab.lab10.l10q1.helper.SalaryFacade;
import com.umwix1002.solution.lab.lab10.l10q1.enums.EmployeeTypeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ng Zhi Yang
 */
@Setter
@Getter
public class TemporaryStaff extends Employee {
    private double totalHours;
    
    private TemporaryStaff(String name, double totalHours) {
        super(name);
        this.totalHours = totalHours;
    }

    public static TemporaryStaff of(String name, double totalHours) {
        return new TemporaryStaff(name, totalHours);
    }

    @Override
    public EmployeeTypeEnum getEmployeeType() {
        return EmployeeTypeEnum.TEMPORARY;
    }
}
