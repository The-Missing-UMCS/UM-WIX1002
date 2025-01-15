package com.umwix1002.solution.pastyear.PastYear2020.Q2.domain;

public class Latitude extends Position {

    public Latitude(char direction, int degree, int minute, int second) {
        super(direction, degree, minute, second);
    }

    @Override
    protected boolean isPositiveDirection() {
        return direction == 'N';
    }

    @Override
    public String toString() {
        return String.format("%.6f Latitude", getValue());
    }

}
