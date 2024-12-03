package com.umwix1002.solution.lab.lab10.l10q4.dal;

import com.google.common.collect.Lists;
import com.umwix1002.solution.lab.lab10.l10q4.domain.Appointment;
import com.umwix1002.solution.lab.lab10.l10q4.util.AppointmentConverter;
import com.umwix1002.solution.lab.util.FileUtil;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.umwix1002.solution.lab.constants.CommonConstant.*;

/**
 * @author Ng Zhi Yang
 */
@AllArgsConstructor
public class Repository {
    
    private String filePath;
    private static final String FORMAT = "%d/%d/%d/%d/%d";
    
    public void save(List<Appointment> appointments) throws Exception {
        StringBuilder sb = new StringBuilder();
        appointments.forEach(appointment -> {
            LocalDateTime start = appointment.getStart();
            LocalDateTime end = appointment.getEnd();
            String info = String.format(FORMAT,
                start.getYear(), start.getMonthValue(), start.getDayOfMonth(),
                start.getHour(), end.getHour());
            sb.append(info).append(LINE_BREAK);
        });
        FileUtil.writeFile(filePath, sb.toString());
    }

    public List<Appointment> load() throws Exception {
        String records = FileUtil.readFile(filePath);
        if(records.isEmpty()) {
            return Lists.newArrayList();
        }
        return Arrays.stream(records.split(LINE_BREAK))
            .map(AppointmentConverter::convert)
            .collect(Collectors.toList());
    }
}
