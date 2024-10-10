package com.umwix1002.solution.lab.lab9.l9q1;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author Ng Zhi Yang
 */
@Data
@RequiredArgsConstructor
@Setter(AccessLevel.PROTECTED)
public abstract class Shape {
    private final String name;
    private double perimeter;
    private double area;
    
    abstract protected void compute();
}
