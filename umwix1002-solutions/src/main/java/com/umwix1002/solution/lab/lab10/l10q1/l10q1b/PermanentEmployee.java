package com.umwix1002.solution.lab.lab10.l10q1.l10q1b;

import com.umwix1002.solution.lab.util.AssertUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Ng Zhi Yang
 */
@Getter
@Setter
public class PermanentEmployee extends Employee {
    private PermanentCategoryEnum category;
    
    private PermanentEmployee(String name, PermanentCategoryEnum category) {
        super(name);
        this.category = category;
    }

    public static PermanentEmployee of(String name, PermanentCategoryEnum category) {
        return new PermanentEmployee(name, category);
    }

    public static PermanentEmployee of(String name, char category) {
        PermanentCategoryEnum categoryEnum = PermanentCategoryEnum.getByCode(category);
        AssertUtil.isNotNull(categoryEnum, "Invalid category code");
        return of(name, categoryEnum);
    }

    @Override
    public EmployeeTypeEnum getEmployeeType() {
        return EmployeeTypeEnum.PERMANENT;
    }
}
