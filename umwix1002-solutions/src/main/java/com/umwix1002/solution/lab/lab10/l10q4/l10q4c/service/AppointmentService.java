package com.umwix1002.solution.lab.lab10.l10q4.l10q4c.service;

import com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain.Appointment;
import com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain.CreateAppointmentModel;

import java.util.List;

public interface AppointmentService {

    boolean makeAppointment(CreateAppointmentModel createAppointmentModel);

    void doneAppointment();

    void doneAppointment(int n);

    List<Appointment> getAppointments();
}
