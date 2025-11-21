package com.umwix1002.solution.lab.util.exception;

import lombok.NoArgsConstructor;

/**
 * @author Ng Zhi Yang
 */
@NoArgsConstructor
public class NegativeValueException extends RuntimeException {
    public NegativeValueException(String message) {
        super(message);
    }
}
