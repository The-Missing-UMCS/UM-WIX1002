package com.umwix1002.solution.pastyear.PastYear2025.py25q3;

import java.util.Date;

public class LibraryMaterial {
    protected String title;
    protected String author;
    protected boolean isAvailable;
    protected Date dateToReturn;

    public LibraryMaterial(String title, String author, boolean isAvailable, Date dateToReturn) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
        this.dateToReturn = dateToReturn;
    }


    public void borrow() {
        if(isAvailable) {
            isAvailable = false;
            dateToReturn = new Date(System.currentTimeMillis() + 14 * 24 * 60 * 60 * 1000); // 1 week from now
        } else {
            throw new IllegalStateException("Material is not available for borrowing.");
        }
    }
}
