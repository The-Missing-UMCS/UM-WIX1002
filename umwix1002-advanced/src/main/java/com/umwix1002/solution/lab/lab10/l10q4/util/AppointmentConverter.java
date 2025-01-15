package com.umwix1002.solution.lab.lab10.l10q4.util;

import com.umwix1002.solution.lab.lab10.l10q4.domain.Appointment;
import com.umwix1002.solution.lab.lab10.l10q4.domain.AppointmentDto;

import java.time.LocalDateTime;

import static com.umwix1002.solution.lab.constants.CommonConstant.COMMA;
import static com.umwix1002.solution.lab.constants.CommonConstant.ZERO;

/**
 * @author Ng Zhi Yang
 */
public class AppointmentConverter {
    /**
     * Convert the appointment information to an {@link Appointment} object
     * @param record the appointment information
     * @return the {@link Appointment} object
     * @throws IllegalArgumentException if the appointment information is invalid
     */
    public static Appointment convert(String record) {
        String[] info = record.trim().split(COMMA);
        
        int year = Integer.parseInt(info[0]);
        int month = Integer.parseInt(info[1]);
        int day = Integer.parseInt(info[2]);
        int startHour = Integer.parseInt(info[3]);
        int endHour = Integer.parseInt(info[4]);

        LocalDateTime start = LocalDateTime.of(year, month, day, startHour, ZERO);
        LocalDateTime end = LocalDateTime.of(year, month, day, endHour, ZERO);
        return new Appointment(start, end);
    }

    /**
     * Convert the appointment information to an {@link AppointmentDto} object
     * @param record the appointment information
     * @return the {@link Appointment} object
     * @throws IllegalArgumentException if the appointment information is invalid
     */
    public static AppointmentDto convertToDto(String record) {
        Appointment appointment = convert(record);
        return new AppointmentDto(appointment.getStart(), appointment.getEnd());
    }

    /**
     * Convert an {@link Appointment} to an {@link AppointmentDto} object
     * @param appointment the appointment information
     * @return the {@link AppointmentDto} object
     */
    public static AppointmentDto toDto(Appointment appointment) {
        return new AppointmentDto(appointment.getStart(), appointment.getEnd());
    }

    /**
     * Convert the {@link AppointmentDto} to an {@link Appointment} object
     * @param appointmentDto the appointment information
     * @return the {@link Appointment} object
     */
    public static Appointment fromDto(AppointmentDto appointmentDto) {
        return new Appointment(appointmentDto.getStart(), appointmentDto.getEnd());
    }
}
