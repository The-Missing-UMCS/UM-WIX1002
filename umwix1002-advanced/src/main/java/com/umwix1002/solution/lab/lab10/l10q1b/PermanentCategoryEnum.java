package com.umwix1002.solution.lab.lab10.l10q1b;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 * @author Ng Zhi Yang
 */

@Getter
@RequiredArgsConstructor
public enum PermanentCategoryEnum {
    A('A', 4_000d),
    B('B', 3_000d),
    C('C', 2_000d);
    
    private final Character code;
    private final Double salary;
    
    public static @Nullable PermanentCategoryEnum getByCode(char code) {
        return Arrays.stream(PermanentCategoryEnum.values())
            .filter(e -> e.getCode() == code)
            .findFirst()
            .orElse(null);
    }
}
