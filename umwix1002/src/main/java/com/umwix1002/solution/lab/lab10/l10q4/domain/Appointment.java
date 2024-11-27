package com.umwix1002.solution.lab.lab10.l10q4.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Appointment implements Searchable, Comparable<Appointment> {
    private LocalDateTime start;
    private LocalDateTime end;

    @Override
    public boolean search(@NotNull LocalDateTime dateStartTime, @NotNull LocalDateTime dateEndTime) {
        return start.isBefore(dateEndTime) && end.isAfter(dateStartTime);
    }

    @Override
    public int compareTo(@NotNull Appointment o) {
        return start.compareTo(o.start);
    }
}
