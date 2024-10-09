package com.umwix1002.solution.lab.lab8.l8q1;

import lombok.Builder;
import lombok.Data;

/**
 * The {@code NumberProperty} class holds configuration parameters for the {@code Number} class.
 * It allows users to specify properties such as size, upper and lower bounds, and duplicate allowance 
 * for generating an integer array.
 *
 * <p>Example Usage:</p>
 * <pre>
 * NumberProperty numberProperty = NumberProperty.builder()
 *     .size(15)
 *     .upperBound(200)
 *     .lowerBound(5)
 *     .isDuplicateAllowed(true)
 *     .build(); // Parameters are validated upon building
 * </pre>
 *
 * @author Ng Zhi Yang
 */
@Data
@Builder
public class NumberProperty {
    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_UPPER_BOUND = 100;
    private static final int DEFAULT_LOWER_BOUND = 0;
    private static final boolean DEFAULT_IS_DUPLICATE_ALLOWED = false;
    
    private int size;
    private int upperBound;
    private int lowerBound;
    private boolean isDuplicateAllowed;

    public static class NumberPropertyBuilder {
        private int size = DEFAULT_SIZE;
        private int upperBound = DEFAULT_UPPER_BOUND;
        private int lowerBound = DEFAULT_LOWER_BOUND;
        private boolean isDuplicateAllowed = DEFAULT_IS_DUPLICATE_ALLOWED;
    }
    
    public NumberProperty build() {
        checkParams();
        return new NumberProperty(size, upperBound, lowerBound, isDuplicateAllowed);
    }
    
    private void checkParams() {
        if (size < 0 || upperBound < lowerBound) {
            throw new IllegalArgumentException("Invalid parameters");
        }
    }
}
