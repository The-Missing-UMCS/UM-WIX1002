package com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain;

import com.umwix1002.solution.lab.util.AssertUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

/**
 * @author Ng Zhi Yang
 */
@Data
@AllArgsConstructor
public class Appointment implements Searchable, Comparable<Appointment> {
    private LocalDateTime start;
    private LocalDateTime end;

    @Override
    public boolean search(@NotNull LocalDateTime dateStartTime, @NotNull LocalDateTime dateEndTime) {
        AssertUtil.isNotNull(dateStartTime, "Date start time cannot be null");
        AssertUtil.isNotNull(dateEndTime, "Date end time cannot be null");
        return start.isBefore(dateEndTime) && end.isAfter(dateStartTime);
    }

    @Override
    public int compareTo(@NotNull Appointment o) {
        return start.compareTo(o.start);
    }
}
