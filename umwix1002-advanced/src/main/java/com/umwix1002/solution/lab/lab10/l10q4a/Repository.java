package com.umwix1002.solution.lab.lab10.l10q4a;

import java.util.List;


public interface Repository {

    void save(List<Appointment> appointments);

    List<Appointment> load();
}
