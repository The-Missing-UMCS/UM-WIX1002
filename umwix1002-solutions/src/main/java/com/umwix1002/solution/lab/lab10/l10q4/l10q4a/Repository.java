package com.umwix1002.solution.lab.lab10.l10q4.l10q4a;

import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import static com.umwix1002.solution.Properties.*;

public class Repository {

    private static final String FILE = chainDir(LAB10, IO_FILES, "l10q4", "appointments.txt");

    private final Queue<Appointment> appointments = new PriorityQueue<>();

    public List<Appointment> getAppointments() {
        return appointments.stream().toList();
    }

    public boolean makeAppointment(LocalDateTime startTime, LocalDateTime endTime) {
        if (hasClashes(startTime, endTime)) {
            return false;
        }
        appointments.add(new Appointment(startTime, endTime));
        return true;
    }

    private boolean hasClashes(LocalDateTime newStartTime, LocalDateTime newEndTime) {
        return appointments.stream().anyMatch(a -> !a.search(newStartTime, newEndTime));
    }

    public void saveAppointment() {
        try (PrintWriter writer = new PrintWriter(FILE)) {
            for (Appointment a : appointments) {
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

    public void loadAppointment() {
        try (Scanner scanner = new Scanner(new FileReader(FILE))) {
            while (scanner.hasNextLine()) {
                String[] info = scanner.nextLine().split("/");
                int year = Integer.parseInt(info[0]);
                int month = Integer.parseInt(info[1]);
                int day = Integer.parseInt(info[2]);
                int startHour = Integer.parseInt(info[3]);
                int endHour = Integer.parseInt(info[4]);

                makeAppointment(
                    LocalDateTime.of(year, month, day, startHour, 0),
                    LocalDateTime.of(year, month, day, endHour, 0)
                );
            }
            System.out.println("Load successfully");
        } catch (Exception ex) {
            System.err.println("Cannot load file. Reason: " + ex.getMessage());
        }
    }

    public void doneAppointment() {
        appointments.poll();
    }

    public void doneAppointment(int n) {
        for (int i = 0; i < n; i++) {
            doneAppointment();
        }
    }
}
