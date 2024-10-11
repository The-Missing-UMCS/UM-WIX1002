package com.umwix1002.solution.lab.lab10.l10q1.domain;

import com.umwix1002.solution.lab.lab10.l10q1.enums.EmployeeTypeEnum;
import com.umwix1002.solution.lab.lab10.l10q1.enums.PermanentCategoryEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * @author Ng Zhi Yang
 */
@Getter
@Setter
public class PermanentEmployee extends Employee {
    private PermanentCategoryEnum category;
    
    public PermanentEmployee(String name, PermanentCategoryEnum category) {
        super(EmployeeTypeEnum.PERMANENT, name);
        this.category = category;
    }
    
    public PermanentEmployee(String name, char category) {
        this(name, PermanentCategoryEnum.getByCode(category));
        validate(this);
    }
    
    private static void validate(PermanentEmployee permanentEmployee) {
        Optional.ofNullable(permanentEmployee.getCategory())
            .orElseThrow(() -> new IllegalArgumentException("Invalid category code"));
    }

    @Override
    public Double getSalary() {
        return category.getSalary();
    }
}
