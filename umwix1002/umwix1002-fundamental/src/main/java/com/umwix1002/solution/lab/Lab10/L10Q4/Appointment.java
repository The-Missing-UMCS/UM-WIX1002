package Lab10.L10Q4;

import java.time.LocalDateTime;

public class Appointment implements Searchable, Comparable<Appointment> {

    LocalDateTime dateStartTime;
    LocalDateTime dateEndTime;

    Appointment(LocalDateTime dateStartTime, LocalDateTime dateEndTime) {
        this.dateStartTime = dateStartTime;
        this.dateEndTime = dateEndTime;
    }

    @Override
    public boolean search(LocalDateTime newStartTime, LocalDateTime newEndTime) {
        return dateStartTime.isAfter(newEndTime) || dateEndTime.isBefore(newStartTime);
    }

    public LocalDateTime getStartTime() {
        return this.dateStartTime;
    }

    public LocalDateTime getEndTime() {
        return this.dateEndTime;
    }

    @Override
    public int compareTo(Appointment a) {
        return dateStartTime.isAfter(a.getStartTime()) ? 1 : -1;
    }

}