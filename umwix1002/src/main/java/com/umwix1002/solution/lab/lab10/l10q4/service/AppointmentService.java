package com.umwix1002.solution.lab.lab10.l10q4.service;

import com.umwix1002.solution.lab.lab10.l10q4.domain.Appointment;
import com.umwix1002.solution.lab.lab10.l10q4.domain.AppointmentDto;
import com.umwix1002.solution.lab.lab10.l10q4.util.AppointmentConverter;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static com.umwix1002.solution.lab.constants.CommonConstant.ZERO;

/**
 * @author Ng Zhi Yang
 */
@AllArgsConstructor
public class AppointmentService {
    private List<Appointment> appointments;
    
    public boolean makeAppointment(AppointmentDto appointmentDto) {
        for (Appointment a : appointments) {
            boolean isClashed = a.search(appointmentDto.getStart(), appointmentDto.getEnd());
            if (isClashed) {
                return false;
            }
        }
        appointments.add(AppointmentConverter.fromDto(appointmentDto));
        Collections.sort(appointments);

        return true;
    }

    public void doneAppointment() {
        appointments.removeFirst();
    }

    public void doneAppointment(int n) {
        for (int i = ZERO; i < n; i++) {
            appointments.removeFirst();
        }
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
