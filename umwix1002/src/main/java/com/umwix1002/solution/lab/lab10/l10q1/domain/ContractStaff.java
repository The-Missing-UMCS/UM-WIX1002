package com.umwix1002.solution.lab.lab10.l10q1.domain;

import com.umwix1002.solution.lab.Properties;
import com.umwix1002.solution.lab.lab10.l10q1.enums.EmployeeTypeEnum;
import com.umwix1002.solution.lab.util.PropertiesUtil;
import lombok.Getter;
import lombok.Setter;

import static com.umwix1002.solution.lab.lab10.config.Constants.*;

/**
 * @author Ng Zhi Yang
 */
@Setter
@Getter
public class ContractStaff extends Employee {
    private double totalSales;
    
    public ContractStaff(String name, double totalSales) {
        super(EmployeeTypeEnum.CONTRACT, name);
        this.totalSales = totalSales;
    }
    
    @Override
    public Double getSalary() {
        final double base = Double.parseDouble(
            PropertiesUtil.read(PROPERTY_FILE_PATH, CONTRACT_STAFF_BASE).orElse("0"));
        final double bonus = Double.parseDouble(
            PropertiesUtil.read(PROPERTY_FILE_PATH, CONTRACT_STAFF_BONUS).orElse("0"));
        return base + totalSales * bonus;
    }
}
