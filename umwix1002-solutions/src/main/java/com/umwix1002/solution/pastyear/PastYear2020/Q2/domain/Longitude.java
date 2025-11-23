package com.umwix1002.solution.pastyear.PastYear2020.Q2.domain;

public class Longitude extends Position {
    public Longitude(char direction, int degree, int minute, int second) {
        super(direction, degree, minute, second);
    }

    @Override
    protected boolean isPositiveDirection() {
        return direction == 'E';
    }

    @Override
    public String toString() {
        return String.format("%.6f Longitude", getValue());
    }
}
