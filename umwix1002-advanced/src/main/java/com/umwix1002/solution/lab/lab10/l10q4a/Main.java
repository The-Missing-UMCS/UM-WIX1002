package com.umwix1002.solution.lab.lab10.l10q4a;

import com.umwix1002.solution.lab.util.FileUtil;
import com.umwix1002.solution.lab.util.LoggerUtil;
import com.umwix1002.solution.lab.util.TableUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static com.umwix1002.solution.lab.Properties.*;
import static com.umwix1002.solution.lab.constants.CommonConstant.LINE_BREAK;
import static com.umwix1002.solution.lab.constants.ConsoleConstants.GREEN;
import static com.umwix1002.solution.lab.constants.ConsoleConstants.RED;
import static com.umwix1002.solution.lab.lab10.config.Constants.APPOINTMENT_FILE_PATH;

/**
 * @author Ng Zhi Yang
 */
public class Main {

    private static final String INPUT = chainDir(LAB10, IO_FILES, "l10q4", "input.csv");

    public static void main(String[] args) throws Exception {
        // load old appointments
        Repository repository = new IORepository(APPOINTMENT_FILE_PATH);
        List<Appointment> old = repository.load();
        AppointmentService service = new AppointmentService(old);

        // make new appointments
        String newAppointments = FileUtil.readFile(INPUT);
        Arrays.stream(newAppointments.split(LINE_BREAK))
            .forEach(newAppointmentLine -> {
                CreateAppointmentModel createAppointmentModel = Converter.convertToCreateModel(
                    newAppointmentLine);
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
