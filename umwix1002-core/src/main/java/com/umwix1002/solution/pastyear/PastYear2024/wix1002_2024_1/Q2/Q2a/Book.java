package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q2.Q2a;

public record Book(String title, String author, Integer yearPublished) {
    @Override
    public String toString() {
        return String.format("Title: %s, Author: %s, Year Published: %d",
            title, author, yearPublished);
    }
}
