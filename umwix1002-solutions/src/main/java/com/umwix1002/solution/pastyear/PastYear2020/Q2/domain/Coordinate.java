package com.umwix1002.solution.pastyear.PastYear2020.Q2.domain;

public record Coordinate(Latitude latitude, Longitude longitude) {
    @Override
    public String toString() {
        return String.format("%s, %s", latitude, longitude);
    }

    public double getLatitudeValue() {
        return latitude.getValue();
    }

    public double getLongitudeValue() {
        return longitude.getValue();
    }
}
