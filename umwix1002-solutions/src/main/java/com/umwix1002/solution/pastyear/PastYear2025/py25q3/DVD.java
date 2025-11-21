package com.umwix1002.solution.pastyear.PastYear2025.py25q3;

import java.time.Duration;
import java.util.Date;

public class DVD extends LibraryMaterial {
    private Duration duration;

    public DVD(String title, String author, boolean isAvailable, Date dateToReturn, Duration duration) {
        super(title, author, isAvailable, dateToReturn);
        this.duration = duration;
    }

    @Override
    public void borrow() {
        super.borrow();
        dateToReturn = new Date(dateToReturn.toInstant().toEpochMilli() - 9 * 24 * 60 * 60 * 1000);
    }
}
