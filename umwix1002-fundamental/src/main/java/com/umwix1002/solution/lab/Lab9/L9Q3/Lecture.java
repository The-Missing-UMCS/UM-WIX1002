package com.umwix1002.solution.lab.Lab9.L9Q3;

public record Lecture(String courseCode, String courseName, int session, int semester, double hour, int studentCount) {
    public double getCreditHour() {
        if (studentCount >= 150) {
            return hour * 3;
        } else if (studentCount >= 100) {
            return hour * 2;
        } else if (studentCount >= 50) {
            return hour * 1.5;
        } else {
            return hour;
        }
    }
}