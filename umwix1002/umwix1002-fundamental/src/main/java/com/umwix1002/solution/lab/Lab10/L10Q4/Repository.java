package Lab10.L10Q4;

import java.util.List;

public abstract class Repository {
    protected final boolean SUCCESS = true;
    protected final boolean FAILED = false;
    abstract List<Appointment> getList();
    abstract boolean makeAppointment(int year, int month, int day, int startTime, int endTime);
    abstract void saveAppointment();
    abstract void loadAppointment();
    abstract void doneAppointment();
    abstract void doneAppointment(int n);
}
