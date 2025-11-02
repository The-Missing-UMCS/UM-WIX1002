package com.umwix1002.solution.lab.lab10.l10q4a;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

import static com.umwix1002.solution.lab.constants.CommonConstant.ZERO;

/**
 * @author Ng Zhi Yang
 */
@AllArgsConstructor
public class AppointmentService {

    private List<Appointment> appointments;

    public boolean makeAppointment(CreateAppointmentModel createAppointmentModel) {
        for (Appointment appointment : appointments) {
            boolean isClashed = appointment.search(createAppointmentModel.start(),
                createAppointmentModel.end());
            if (isClashed) {
                return false;
            }
        }
        appointments.add(Converter.convertToModel(createAppointmentModel));
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
