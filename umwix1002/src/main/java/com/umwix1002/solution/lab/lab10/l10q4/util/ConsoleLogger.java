package com.umwix1002.solution.lab.lab10.l10q4.util;

import com.umwix1002.solution.lab.lab10.l10q4.domain.Appointment;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static com.umwix1002.solution.lab.constants.CommonConstant.*;
import static com.umwix1002.solution.lab.constants.ConsoleConstants.*;

public class ConsoleLogger {
    private static final int SIZE_1 = 14;
    private static final int SIZE_2 = 14;
    private static final int SIZE_3 = 17;

    private static final String DATE_FORMAT = "%02d-%02d-%d";
    private static final String TIME_FORMAT = "%02d:%02d";
    private static final String MAGIC_FORMAT = "|%" + SIZE_1 + "s|%" + SIZE_2 + "s|%" + SIZE_3 + "s|" + LINE_BREAK;


    public static void logResult(LocalDate localDate, LocalTime start, LocalTime end, boolean result) {
        final String color = result ? GREEN : RED;
        final String pattern = color(" ==> %2d-%2d-%d -->  %2d:%2s ~ %2d:%2s  --> Appointment %s.\n", color);
        final String label = result ? "Success" : "Failed";
        System.out.printf(pattern, localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(),
                start.getHour(), "00", end.getHour(), "00", label);
    }

    public static void logAppointments(List<Appointment> appointments) {
        System.out.print(decorator());
        System.out.printf(formatted("Appointment", "Date", "Time"));
        System.out.print(decorator());

        for (int i = ZERO; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            LocalDateTime start = appointment.getStart();
            LocalDateTime end = appointment.getEnd();
            System.out.printf(formatted(
                    String.valueOf(i + ONE),
                    String.format(DATE_FORMAT, start.getDayOfMonth(), start.getMonthValue(), start.getYear()),
                    String.format(TIME_FORMAT + " - " + TIME_FORMAT,
                            start.getHour(), start.getMinute(), end.getHour(), end.getMinute())));
        }
        System.out.printf(formatted(BLANK, BLANK, BLANK));
        System.out.printf(decorator());
    }

    private static String color(String text, String color) {
        return color + text + RESET;
    }

    private static String formatted(String s1, String s2, String s3) {
        return String.format(MAGIC_FORMAT,
                StringUtils.center(s1, SIZE_1),
                StringUtils.center(s2, SIZE_2),
                StringUtils.center(s3, SIZE_3));
    }

    private static String decorator() {
        return formatted(DASH.repeat(SIZE_1), DASH.repeat(SIZE_2), DASH.repeat(SIZE_3));
    }
}
