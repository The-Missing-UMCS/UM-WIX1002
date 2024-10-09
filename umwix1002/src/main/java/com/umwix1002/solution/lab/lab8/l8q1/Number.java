package com.umwix1002.solution.lab.lab8.l8q1;

import com.umwix1002.solution.lab.CommonConstant;
import lombok.*;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * The {@code Number} class is designed to encapsulate properties related to an array of integers.
 * It takes parameters from the {@code NumberProperty} and generates an int[] array based on these parameters.
 *
 * <p>Key Features:</p>
 * <ul>
 *     <li>The class uses a property-based approach where all properties can be set at once using the {@code setProperty} method.</li>
 *     <li>The fields of the {@code Number} class cannot be set independently; they must be set through the {@code NumberProperty}.</li>
 *     <li>Each time the properties are set, the int[] array is regenerated using Java's {@code IntStream}.</li>
 * </ul>
 *
 * <p>Important Notes:</p>
 * <ul>
 *     <li>Ensure that the {@code NumberProperty} is properly configured before calling {@code setProperty}.</li>
 *     <li>The {@code numbers} field is private and can only be modified internally; it cannot be accessed or modified from outside the class.</li>
 *     <li>When duplicates are not allowed, the array will be filled with unique integers generated within the specified bounds.</li>
 *     <li>Consider the performance implications when generating large arrays, especially when uniqueness is enforced.</li>
 * </ul>
 *
 * <p>Example Usage:</p>
 * <pre>
 * NumberProperty numberProperty = new NumberProperty(10, 100, 1, false);
 * Number number = Number.of(numberProperty);
 * </pre>
 *
 * @author Ng Zhi Yang
 */
@Getter
@ToString
@Setter
@NoArgsConstructor
public class Number {
    private int size;
    private int upperBound;
    private int lowerBound;
    private boolean isDuplicateAllowed;
    
    @Setter(AccessLevel.PRIVATE)
    private int[] numbers;
    
    private Number(int size, int upperBound, int lowerBound, boolean isDuplicateAllowed, int[] numbers) {
        this.size = size;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
        this.isDuplicateAllowed = isDuplicateAllowed;
        this.numbers = numbers;
    }
    
    public void setProperty(NumberProperty numberProperty) {
        init(this, numberProperty);
    }
    
    public static Number of(NumberProperty numberProperty) {
        Number number = new Number();
        init(number, numberProperty);
        return number;
    }
    
    private static void init(Number number, NumberProperty numberProperty) {
        number.setSize(numberProperty.getSize());
        number.setUpperBound(numberProperty.getUpperBound());
        number.setLowerBound(numberProperty.getLowerBound());
        number.setDuplicateAllowed(numberProperty.isDuplicateAllowed());
        number.setNumbers(getArray(numberProperty));
    }
    
    private static int[] getArray(NumberProperty numberProperty) {
        Random random = new Random();        
        if(numberProperty.isDuplicateAllowed()) {
            return random.ints(numberProperty.getSize(), numberProperty.getLowerBound(), 
                numberProperty.getUpperBound() + CommonConstant.ONE).toArray();
        } else {
            return IntStream.generate(() -> 
                    random.nextInt(numberProperty.getUpperBound() - numberProperty.getLowerBound()) + numberProperty.getLowerBound())
                .distinct().limit(numberProperty.getSize()).toArray();
        }
    }
}
