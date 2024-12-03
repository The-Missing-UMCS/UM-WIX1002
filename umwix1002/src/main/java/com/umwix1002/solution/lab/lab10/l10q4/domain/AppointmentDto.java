package com.umwix1002.solution.lab.lab10.l10q4.domain;

import java.time.LocalDateTime;

/**
 * The {@code AppointmentDto} class is used to carry different semantic meaning than the Appointment class.
 * The {@code Appointment} class represents a registered appointment in the system, while the {@code AppointmentDto}
 * carries the information of an appointment that has not been registered yet. 
 * This class is used for creating a new appointment and will be converted into an {@code Appointment} object
 * once it is registered.
 *
 * @author Ng Zhi Yang
 */
public class AppointmentDto extends Appointment {
    public AppointmentDto(LocalDateTime start, LocalDateTime end) {
        super(start, end);
    }
}
