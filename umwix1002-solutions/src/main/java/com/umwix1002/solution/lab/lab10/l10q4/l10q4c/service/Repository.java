package com.umwix1002.solution.lab.lab10.l10q4.l10q4c.service;

import com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain.Appointment;

import java.time.LocalDateTime;
import java.util.List;


public interface Repository {

    boolean save(Appointment appointment);

    void removeFirstN(int n);

    List<Appointment> searchWithinRange(LocalDateTime start, LocalDateTime end);

    List<Appointment> findAll();

    void persist();

    void load();
}
