package com.umwix1002.solution.lab.lab3.l3q1.advanced.strategy;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 * @author Ng Zhi Yang
 */
public enum OperationEnum {
    ADDITION('+'),
    SUBTRACTION('-'),
    MULTIPLICATION('*'),
    DIVISION('/'),
    MODULO('%');
    
    private Character code;
    
    OperationEnum(Character code) {
        this.code = code;
    }
    
    public static @Nullable OperationEnum getByCode(Character code) {
        return Arrays.stream(OperationEnum.values())
            .filter(operation -> operation.code.equals(code))
            .findFirst()
            .orElse(null);
    }
    
}
