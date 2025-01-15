package com.umwix1002.solution.lab.Lab10.L10Q4;

import java.util.List;

public interface Repository {
    List<Appointment> getList();
    boolean makeAppointment(int year, int month, int day, int startTime, int endTime);
    void saveAppointment();
    void loadAppointment();
    void doneAppointment();
    void doneAppointment(int n);
}
