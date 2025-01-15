package com.umwix1002.solution.lab.Lab10.L10Q4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IORepository implements Repository {
    private static final boolean SUCCESS = true;
    private static final boolean FAILED = false;
    private static final String FILE = "umwix1002-fundamental/src/main/java/com/umwix1002/solution/lab/Lab10/io_files/appointment.txt";

    private final ArrayList<Appointment> appointmentList = new ArrayList<>();

    @Override
    public List<Appointment> getList() {
        return appointmentList;
    }

    public boolean makeAppointment(int year, int month, int day, int startTime, int endTime) {
        return makeAppointment(year, month, day, startTime, endTime, true);
    }

    public boolean makeAppointment(int year, int month, int day, int startTime, int endTime, boolean enabled) {
        LocalDateTime newStartTime = LocalDateTime.of(year, month, day, startTime, 0);
        LocalDateTime newEndTime = LocalDateTime.of(year, month, day, endTime, 0);

        if (hasClashes(newStartTime, newEndTime)) {
            if (enabled) {
                System.out.print(message(day, month, year, startTime, endTime, FAILED));
            }
            return false;
        }

        appointmentList.add(new Appointment(newStartTime, newEndTime));
        Collections.sort(appointmentList);
        if (enabled) {
            System.out.print(message(day, month, year, startTime, endTime, SUCCESS));
        }
        return true;
    }

    private boolean hasClashes(LocalDateTime newStartTime, LocalDateTime newEndTime) {
        return appointmentList.stream().anyMatch(a -> !a.search(newStartTime, newEndTime));
    }

    public void saveAppointment() {
        try (PrintWriter writer = new PrintWriter(FILE)) {
            for (Appointment a : appointmentList) {
                LocalDateTime startTime = a.startTime();
                LocalDateTime endTime = a.endTime();
                String info = String.format("%d/%d/%d/%d/%d",
                    startTime.getYear(), startTime.getMonthValue(), startTime.getDayOfMonth(),
                    startTime.getHour(), endTime.getHour());
                writer.println(info);
            }
            System.err.println("Save successfully");
        } catch (Exception ex) {
            System.out.println("Cannot save file. Reason: " + ex.getMessage());
        }
    }

    @Override
    public void loadAppointment() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] info = line.split("/");
                makeAppointment(
                    Integer.parseInt(info[0]), // year
                    Integer.parseInt(info[1]), // month
                    Integer.parseInt(info[2]), // day
                    Integer.parseInt(info[3]), // startHour
                    Integer.parseInt(info[4]), // endHour
                    false);
            }
            System.err.println("Load successfully");
        } catch (Exception ex) {
            System.out.println("Cannot load file. Reason: " + ex.getMessage());
        }
    }

    @Override
    public void doneAppointment() {
        appointmentList.removeFirst();
    }

    @Override
    public void doneAppointment(int n) {
        for (int i = 0; i < n; i++) {
            doneAppointment();
        }
    }

    private String message(int day, int month, int year, int startTime, int endTime, boolean isSuccess) {
        return String.format(" ==> %2d-%2d-%d -->  %2d:%2s ~ %2d:%2s  --> Appointment %s.\n",
            day, month, year, startTime, "00", endTime, "00", isSuccess ? "Success" : "Failed");
    }

}
