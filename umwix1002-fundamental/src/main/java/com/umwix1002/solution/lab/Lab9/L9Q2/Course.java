package com.umwix1002.solution.lab.Lab9.L9Q2;

public record Course(String courseCode, String courseName, int session, int semester, int marks) {
    public String getGrade() {
        String grade;
        if (marks >= 85) {
            grade = "A";
        } else if (marks >= 80) {
            grade = "A-";
        } else if (marks >= 75) {
            grade = "B+";
        } else if (marks >= 70) {
            grade = "B";
        } else if (marks >= 65) {
            grade = "B-";
        } else if (marks >= 60) {
            grade = "C+";
        } else if (marks >= 55) {
            grade = "C";
        } else if (marks >= 45) {
            grade = "D";
        } else if (marks >= 35) {
            grade = "E";
        } else {
            grade = "F";
        }
        return grade;
    }
}
