package com.umwix1002.solution.pastyear.PastYear2020.Q2;

import com.umwix1002.solution.pastyear.PastYear2020.Q2.domain.Coordinate;
import lombok.RequiredArgsConstructor;

import static java.lang.Math.*;

@RequiredArgsConstructor
public class CoordinateDistanceCalculator {
    public static final int R = 6371;
    private final Coordinate c1;
    private final Coordinate c2;

    public double getLatitudeDiff() {
        return c2.getLatitudeValue() - c1.getLatitudeValue();
    }

    public double getLongitudeDiff() {
        return c2.getLatitudeValue() - c1.getLongitudeValue();
    }

    public double calcDistance() {
        double la1 = Math.toRadians(c1.getLatitudeValue());
        double la2 = Math.toRadians(c2.getLatitudeValue());
        double laDiff = Math.toRadians(getLatitudeDiff());
        double loDiff = Math.toRadians(getLongitudeDiff());

        double a = pow(sin(laDiff / 2), 2) + cos(la1) * cos(la2) * pow(sin(loDiff / 2), 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));

        return R * c;
    }
}
