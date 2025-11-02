package com.umwix1002.solution.lab.lab10.l10q4b;

import java.time.LocalDateTime;
import java.util.List;

public class Presenter {

    private final int COL_1_SIZE = 14;
    private final int COL_2_SIZE = 14;
    private final int COL_3_SIZE = 17;

    private final String FORMAT = "|%"
                                  + COL_1_SIZE
                                  + "s|%"
                                  + COL_2_SIZE
                                  + "s|%"
                                  + COL_3_SIZE
                                  + "s|\n";

    Presenter() {
    }

    public void present(List<Appointment> appointments) {
        System.out.print(decorator());
        System.out.printf(formatted("Appointment", "Date", "Time"));
        System.out.print(decorator());

        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            LocalDateTime startTime = appointment.startTime();
            LocalDateTime endTime = appointment.endTime();
            int appointmentNo = i + 1;

            System.out.printf(
                formatted(
                    String.valueOf(appointmentNo),
                    // Appointment Start Time
                    String.format(
                        "%02d-%02d-%d",
                        startTime.getDayOfMonth(),
                        startTime.getMonthValue(),
                        startTime.getYear()
                    ),
                    // Appointment End Time
                    String.format(
                        "%02d:%02d - %02d:%02d",
                        startTime.getHour(), 0,
                        endTime.getHour(), 0
                    )
                )
            );
        }
        System.out.printf(formatted("", "", ""));
        System.out.printf(decorator());
    }

    private String decorator() {
        return formatted("-".repeat(COL_1_SIZE), "-".repeat(COL_2_SIZE), "-".repeat(COL_3_SIZE));
    }

    private String formatted(String s1, String s2, String s3) {
        return String.format(
            FORMAT,
            middleString(s1, COL_1_SIZE),
            middleString(s2, COL_2_SIZE),
            middleString(s3, COL_3_SIZE)
        );
    }

    private String middleString(String s, int length) {
        if (s.length() >= length) {
            return s.substring(0, length);
        }

        int left = (length - s.length()) / 2;
        int right = length - s.length() - left;
        return " ".repeat(left) + s + " ".repeat(right);
    }

}