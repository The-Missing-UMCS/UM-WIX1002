package com.umwix1002.solution.lab.lab10.l10q4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.umwix1002.solution.lab.Properties.*;
import static com.umwix1002.solution.lab.constants.CommonConstant.COMMA;
import static com.umwix1002.solution.lab.lab10.l10q4.ConsoleLogger.logAppointments;
import static com.umwix1002.solution.lab.lab10.l10q4.ConsoleLogger.logResult;

public class Main {
    private static final String APPOINTMENT = chainDir(LAB10, IO_FILES, "l10q4", "appointments.txt");
    private static final String INPUT = chainDir(LAB10, IO_FILES, "l10q4", "input.csv");

    public static void main(String[] args) throws Exception {
        Repository repository = new Repository();
        List<Appointment> old = repository.load(APPOINTMENT);
        AppointmentService service = new AppointmentService(old);
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] appointmentData = line.split(COMMA);
                int year = Integer.parseInt(appointmentData[0]);
                int month = Integer.parseInt(appointmentData[1]);
                int day = Integer.parseInt(appointmentData[2]);
                LocalTime startTime = LocalTime.parse(appointmentData[3], DateTimeFormatter.ofPattern("H:mm"));
                LocalTime endTime = LocalTime.parse(appointmentData[4], DateTimeFormatter.ofPattern("H:mm"));
                LocalDate appointmentDate = LocalDate.of(year, month, day);
                makeAppointment(service, appointmentDate, startTime, endTime);
            }
        }

        logAppointments(service.getAppointments());
    }

    public static void makeAppointment(AppointmentService service, LocalDate localDate, LocalTime start, LocalTime end) {
        boolean isSuccess = service.makeAppointment(localDate.getYear(), localDate.getMonthValue(),
                localDate.getDayOfMonth(), start.getHour(), end.getHour());
        logResult(localDate, start, end, isSuccess);
    }

}
