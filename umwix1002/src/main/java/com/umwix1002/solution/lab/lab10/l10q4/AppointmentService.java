package com.umwix1002.solution.lab.lab10.l10q4;

import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static com.umwix1002.solution.lab.constants.CommonConstant.ZERO;

@AllArgsConstructor
public class AppointmentService {
    private List<Appointment> appointments;

    public boolean makeAppointment(int year, int month, int day, int startTime, int endTime) {
        LocalDateTime newStartTime = LocalDateTime.of(year, month, day, startTime, ZERO);
        LocalDateTime newEndTime = LocalDateTime.of(year, month, day, endTime, ZERO);

        for (Appointment a : appointments) {
            if (a.search(newStartTime, newEndTime)) {
                return false;
            }
        }

        appointments.add(new Appointment(newStartTime, newEndTime));
        Collections.sort(appointments);

        return true;
    }

    public void doneAppointment() {
        appointments.removeFirst();
    }

    public void doneAppointment(int n) {
        for (int i = ZERO; i < n; i++)
            appointments.removeFirst();
    }

    public void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    public Appointment getAppointment(int index) {
        return appointments.get(index);
    }

    public List<Appointment> getAppointments() {
        return List.of(appointments.toArray(Appointment[]::new));
    }
}
