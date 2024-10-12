package com.umwix1002.solution.lab.lab10.l10q4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.umwix1002.solution.lab.constants.CommonConstant.*;

public class Repository {
    public void save(List<Appointment> appointments, String file) throws Exception {
        try (PrintWriter writer = new PrintWriter(file)) {
            appointments.forEach(appointment -> {
                LocalDateTime start = appointment.getStart();
                LocalDateTime end = appointment.getEnd();
                String info = String.format("%d/%d/%d/%d/%d",
                        start.getYear(), start.getMonthValue(), start.getDayOfMonth(),
                        start.getHour(), end.getHour());
                writer.println(info);
            });
        }
    }

    public List<Appointment> load(String file) throws Exception {
        List<Appointment> appointments = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split(SLASH);
                appointments.add(toAppointment(info));
            }
        }
        return appointments;
    }

    /**
     * Convert the appointment information to an {@link Appointment} object
     * @param info the appointment information
     * @return the {@link Appointment} object
     * @throws IllegalArgumentException if the appointment information is invalid
     */
    private Appointment toAppointment(String[] info) {
        if(info.length != 5) {
            throw new IllegalArgumentException("Invalid appointment information");
        }

        int year = Integer.parseInt(info[0]);
        int month = Integer.parseInt(info[1]);
        int day = Integer.parseInt(info[2]);
        int startHour = Integer.parseInt(info[3]);
        int endHour = Integer.parseInt(info[4]);

        LocalDateTime start = LocalDateTime.of(year, month, day, startHour, ZERO);
        LocalDateTime end = LocalDateTime.of(year, month, day, endHour, ZERO);
        return new Appointment(start, end);
    }
}
