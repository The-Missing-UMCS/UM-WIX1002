package com.umwix1002.solution.lab.lab10.l10q4.l10q4c.service;

import com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain.Appointment;
import com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain.CreateAppointmentModel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final Repository repository;

    public boolean makeAppointment(CreateAppointmentModel createAppointmentModel) {
        boolean isClashed = !repository.searchWithinRange(createAppointmentModel.start(),
            createAppointmentModel.end()).isEmpty();

        if (isClashed) {
            return false;
        }

        repository.save(Converter.convertToModel(createAppointmentModel));
        return true;
    }

    public void doneAppointment() {
        repository.removeFirstN(1);
    }

    public void doneAppointment(int n) {
        repository.removeFirstN(n);
    }

    public List<Appointment> getAppointments() {
        return repository.findAll();
    }
}
