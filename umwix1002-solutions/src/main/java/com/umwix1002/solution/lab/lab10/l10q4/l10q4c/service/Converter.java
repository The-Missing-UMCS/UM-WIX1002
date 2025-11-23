package com.umwix1002.solution.lab.lab10.l10q4.l10q4c.service;

import com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain.Appointment;
import com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain.CreateAppointmentModel;

import java.time.LocalDateTime;


public class Converter {

    /**
     * Convert the appointment information to an {@link Appointment} object
     *
     * @param record the appointment information
     * @return the {@link Appointment} object
     * @throws IllegalArgumentException if the appointment information is invalid
     */
    public static Appointment convert(String record) {
        String[] info = record.trim().split(",");

        int year = Integer.parseInt(info[0]);
        int month = Integer.parseInt(info[1]);
        int day = Integer.parseInt(info[2]);
        int startHour = Integer.parseInt(info[3]);
        int endHour = Integer.parseInt(info[4]);

        LocalDateTime start = LocalDateTime.of(year, month, day, startHour, 0);
        LocalDateTime end = LocalDateTime.of(year, month, day, endHour, 0);
        return new Appointment(start, end);
    }

    /**
     * Convert the appointment information to an {@link CreateAppointmentModel} object
     *
     * @param record the appointment information
     * @return the {@link Appointment} object
     * @throws IllegalArgumentException if the appointment information is invalid
     */
    public static CreateAppointmentModel convertToCreateModel(String record) {
        Appointment appointment = convert(record);
        return new CreateAppointmentModel(appointment.getStart(), appointment.getEnd());
    }


    /**
     * Convert the {@link CreateAppointmentModel} to an {@link Appointment} object
     *
     * @param createAppointmentModel the appointment information
     * @return the {@link Appointment} object
     */
    public static Appointment convertToModel(CreateAppointmentModel createAppointmentModel) {
        return new Appointment(createAppointmentModel.start(), createAppointmentModel.end());
    }
}
