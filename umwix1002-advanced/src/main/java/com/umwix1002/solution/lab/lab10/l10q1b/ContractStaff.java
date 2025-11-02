package com.umwix1002.solution.lab.lab10.l10q1b;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ng Zhi Yang
 */
@Setter
@Getter
public class ContractStaff extends Employee {

    private double totalSales;

    private ContractStaff(String name, double totalSales) {
        super(name);
        this.totalSales = totalSales;
    }

    public static ContractStaff of(String name, double totalSales) {
        return new ContractStaff(name, totalSales);
    }

    @Override
    public EmployeeTypeEnum getEmployeeType() {
        return EmployeeTypeEnum.CONTRACT;
    }
}
