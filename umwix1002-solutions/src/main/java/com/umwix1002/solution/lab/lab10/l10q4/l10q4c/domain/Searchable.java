package com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

/**
 * To follow the lab requirement, the name Searchable is used. However, it is used to check if the
 * current object is or not clashed with the given time frame.
 *
 * @author Ng Zhi Yang
 */
public interface Searchable {

    /**
     * Search if the current object within the given time frame
     *
     * @param startDateTime {@link LocalDateTime} start time
     * @param endDateTime {@link LocalDateTime} end time
     * @return {@link Boolean} true if the current object within the given time frame
     */
    boolean search(@NotNull LocalDateTime startDateTime, @NotNull LocalDateTime endDateTime);
}
