package com.umwix1002.solution.lab.lab10.l10q4;

import com.umwix1002.solution.lab.lab10.l10q4.dal.Repository;
import com.umwix1002.solution.lab.lab10.l10q4.domain.Appointment;
import com.umwix1002.solution.lab.lab10.l10q4.domain.AppointmentDto;
import com.umwix1002.solution.lab.lab10.l10q4.service.AppointmentService;
import com.umwix1002.solution.lab.lab10.l10q4.util.AppointmentConverter;
import com.umwix1002.solution.lab.lab10.l10q4.util.ConsoleLogger;
import com.umwix1002.solution.lab.util.FileUtil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static com.umwix1002.solution.lab.Properties.*;
import static com.umwix1002.solution.lab.constants.CommonConstant.LINE_BREAK;
import static com.umwix1002.solution.lab.lab10.config.Constants.APPOINTMENT_FILE_PATH;
import static com.umwix1002.solution.lab.lab10.l10q4.util.ConsoleLogger.logAppointments;

/**
 * @author Ng Zhi Yang
 */
public class Main {
    private static final String INPUT = chainDir(LAB10, IO_FILES, "l10q4", "input.csv");

    public static void main(String[] args) throws Exception {
        // load old appointments
        Repository repository = new Repository(APPOINTMENT_FILE_PATH);
        List<Appointment> old = repository.load();
        AppointmentService service = new AppointmentService(old);

        // make new appointments
        String newAppointments = FileUtil.readFile(INPUT);
        Arrays.stream(newAppointments.split(LINE_BREAK)).forEach(newAppointmentLine -> {
            AppointmentDto newAppointmentDto = AppointmentConverter.convertToDto(newAppointmentLine);
            boolean isSuccess = service.makeAppointment(newAppointmentDto);
            logResult(newAppointmentDto, isSuccess);
        });

        logAppointments(service.getAppointments());
    }

    private static void logResult(AppointmentDto newAppointmentDto, boolean isSuccess) {
        LocalDate localDate = newAppointmentDto.getStart().toLocalDate();
        LocalTime start = newAppointmentDto.getStart().toLocalTime();
        LocalTime end = newAppointmentDto.getEnd().toLocalTime();
        ConsoleLogger.logResult(localDate, start, end, isSuccess);
    }
}
