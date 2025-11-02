package com.umwix1002.solution.lab.lab10.l10q4b;

import java.time.LocalDateTime;

public record Appointment(LocalDateTime startTime,
                          LocalDateTime endTime) implements Searchable, Comparable<Appointment> {

    @Override
    public boolean search(LocalDateTime newStartTime, LocalDateTime newEndTime) {
        return startTime.isAfter(newEndTime) || endTime.isBefore(newStartTime);
    }

    @Override
    public int compareTo(Appointment a) {
        if (startTime.isEqual(a.startTime())) {
            return 0;
        }
        return endTime.isAfter(a.startTime()) ? 1 : -1;
    }
}