package com.umwix1002.solution.lab.lab10.l10q1.domain;

import com.umwix1002.solution.lab.lab10.config.Constants;
import com.umwix1002.solution.lab.lab10.l10q1.enums.EmployeeTypeEnum;
import com.umwix1002.solution.lab.util.PropertiesUtil;
import lombok.Getter;
import lombok.Setter;

import static com.umwix1002.solution.lab.lab10.config.Constants.PROPERTY_FILE_PATH;
import static com.umwix1002.solution.lab.lab10.config.Constants.TEMPORARY_STAFF_PAY_RATE;

/**
 * @author Ng Zhi Yang
 */
@Setter
@Getter
public class TemporaryStaff extends Employee {
    private double totalHours;
    
    public TemporaryStaff(String name, double totalHours) {
        super(EmployeeTypeEnum.TEMPORARY, name);
        this.totalHours = totalHours;
    }
    
    @Override
    public Double getSalary() {
        final double payRate = Double.parseDouble(PropertiesUtil.read(PROPERTY_FILE_PATH, TEMPORARY_STAFF_PAY_RATE).orElse("0"));
        return payRate * totalHours;
    }
}
