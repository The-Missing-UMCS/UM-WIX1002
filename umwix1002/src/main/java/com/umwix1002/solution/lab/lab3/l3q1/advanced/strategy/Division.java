package com.umwix1002.solution.lab.lab3.l3q1.advanced.strategy;

public class Division implements Operation {

    @Override
    public Integer execute(Integer a, Integer b) throws ArithmeticException{
        return a / b;
    }
}
