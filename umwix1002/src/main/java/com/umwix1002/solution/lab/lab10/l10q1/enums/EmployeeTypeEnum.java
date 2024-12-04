package com.umwix1002.solution.lab.lab10.l10q1.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 * @author Ng Zhi Yang
 */

@Getter
@RequiredArgsConstructor
public enum EmployeeTypeEnum {
    PERMANENT("PERMANENT", "Permanent Employee"),
    CONTRACT("CONTRACT", "Contract Staff"),
    TEMPORARY("TEMPORARY", "Temporary Employee");
    
    private final String code;
    private final String description;
    
    public static @Nullable EmployeeTypeEnum getByCode(String code) {
        return Arrays.stream(EmployeeTypeEnum.values())
            .filter(e -> e.getCode().equals(code))
            .findFirst()
            .orElse(null);
    }
}
