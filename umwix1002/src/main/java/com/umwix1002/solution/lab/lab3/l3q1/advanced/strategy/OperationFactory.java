package com.umwix1002.solution.lab.lab3.l3q1.advanced.strategy;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * @author Ng Zhi Yang
 */
public class OperationFactory {
    public static @NotNull Operation getOperation(@Nullable OperationEnum operationEnum) {
        return Optional.ofNullable(operationEnum)
            .map(operation -> switch (operation) {
                case OperationEnum.ADDITION -> new Addition();
                case OperationEnum.SUBTRACTION -> new Subtraction();
                case OperationEnum.MULTIPLICATION -> new Multiplication();
                case OperationEnum.DIVISION -> new Division();
                case OperationEnum.MODULO -> new Modulo();
            }).orElseThrow(() -> new IllegalArgumentException("Invalid operation"));
    }
}
