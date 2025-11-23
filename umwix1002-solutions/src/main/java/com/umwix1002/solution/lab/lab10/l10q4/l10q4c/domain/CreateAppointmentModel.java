package com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

/**
 * The {@code AppointmentDto} class is used to carry different semantic meaning than the
 * {@code Appointment} class.
 * The {@code Appointment} class represents a registered appointment in the system, while the
 * {@code AppointmentDto}
 * carries the information of an appointment that has not been registered yet.
 * This class is used for creating a new appointment and will be converted into an
 * {@code Appointment} object
 * once it is registered.
 *
 * @author Ng Zhi Yang
 */
public record CreateAppointmentModel(
    LocalDateTime start,
    LocalDateTime end
) implements Searchable, Comparable<CreateAppointmentModel> {

    @Override
    public boolean search(@NotNull LocalDateTime startDateTime,
                          @NotNull LocalDateTime endDateTime) {
        return !(start.isAfter(endDateTime) || end.isBefore(startDateTime));
    }

    @Override
    public int compareTo(@NotNull CreateAppointmentModel o) {
        return o.start().compareTo(start());
    }
}
