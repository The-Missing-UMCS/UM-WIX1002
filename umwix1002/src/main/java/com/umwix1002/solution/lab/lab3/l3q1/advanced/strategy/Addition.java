package com.umwix1002.solution.lab.lab3.l3q1.advanced.strategy;

/**
 * @author Ng Zhi Yang
 */
public class Addition implements Operation {
    @Override
    public Integer execute(Integer a, Integer b) {
       return a + b; 
    }
}
