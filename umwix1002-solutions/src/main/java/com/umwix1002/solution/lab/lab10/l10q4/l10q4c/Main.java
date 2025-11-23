package com.umwix1002.solution.lab.lab10.l10q4.l10q4c;

import com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain.Appointment;
import com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain.CreateAppointmentModel;
import com.umwix1002.solution.lab.lab10.l10q4.l10q4c.service.*;
import com.umwix1002.solution.lab.util.LoggerUtil;
import com.umwix1002.solution.lab.util.TableUtil;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static com.umwix1002.solution.Properties.*;
import static com.umwix1002.solution.lab.constants.ConsoleConstants.GREEN;
import static com.umwix1002.solution.lab.constants.ConsoleConstants.RED;

public class Main {

    public static void main(String[] args) throws Exception {
        // 1. load old appointments
        String appointmentFile = chainDir(LAB10, IO_FILES, "l10q4", "appointments.txt");
        Repository repository = RepositoryImpl.load(appointmentFile);
        AppointmentService service = new AppointmentServiceImpl(repository);

        // 2. make new appointments
        String inputFile = chainDir(LAB10, IO_FILES, "l10q4", "input.csv");
        Files.readAllLines(Paths.get(inputFile))
            .stream()
            .map(Converter::convertToCreateModel)
            .forEach(createAppointmentModel -> {
                boolean isSuccess = service.makeAppointment(createAppointmentModel);
                logResult(createAppointmentModel, isSuccess);
            });

        logAppointments(service.getAppointments());
    }

    private static void logResult(CreateAppointmentModel createAppointmentModel,
                                  boolean isSuccess) {
        // args
        LocalDate localDate = createAppointmentModel.start().toLocalDate();
        LocalTime start = createAppointmentModel.start().toLocalTime();
        LocalTime end = createAppointmentModel.end().toLocalTime();

        // logging properties
        final String pattern = " ==> %2d-%2d-%d -->  %2d:%2s ~ %2d:%2s  --> Appointment %s."
                               + System.lineSeparator();
        final String color = isSuccess ? GREEN : RED;
        final String label = isSuccess ? "Success" : "Failed";

        LoggerUtil.logWithColor(color, pattern,
            localDate.getDayOfMonth(), localDate.getMonthValue(), localDate.getYear(),
            start.getHour(), "00", end.getHour(), "00", label);
    }

    public static void logAppointments(List<Appointment> appointments) {
        final int[] counter = {1};
        TableUtil.printTableWithData(new String[]{"Appointment", "Date", "Time"},
            appointments.stream().map(
                appointment -> {
                    final String dateFormat = "%02d-%02d-%d ";
                    final String timeFormat = "%02d:%02d  ";
                    String[] data = new String[3];
                    data[0] = String.valueOf(counter[0]++);
                    data[1] = String.format(dateFormat,
                        appointment.getStart().getDayOfMonth(),
                        appointment.getStart().getMonthValue(),
                        appointment.getStart().getYear());
                    data[2] = String.format(timeFormat + " - " + timeFormat,
                        appointment.getStart().getHour(), appointment.getStart().getMinute(),
                        appointment.getEnd().getHour(), appointment.getEnd().getMinute());
                    return data;
                }
            ).toList());
    }
}
