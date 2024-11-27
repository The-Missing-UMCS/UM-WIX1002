package com.umwix1002.solution.lab.lab10.l10q4.domain;

import java.time.LocalDateTime;

public interface Searchable {
    /**
     * Search if the current object within the given time frame
     * @param startDateTime {@link LocalDateTime} start time
     * @param endDateTime {@link LocalDateTime} end time
     * @return {@link Boolean} true if the current object within the given time frame
     */
    boolean search(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
