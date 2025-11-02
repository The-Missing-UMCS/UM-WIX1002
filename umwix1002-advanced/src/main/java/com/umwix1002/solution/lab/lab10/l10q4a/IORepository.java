package com.umwix1002.solution.lab.lab10.l10q4a;

import com.google.common.collect.Lists;
import com.umwix1002.solution.lab.util.FileUtil;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.umwix1002.solution.lab.constants.CommonConstant.LINE_BREAK;

@AllArgsConstructor
public class IORepository implements Repository {

    private final String filePath;

    @Override
    @SneakyThrows
    public void save(List<Appointment> appointments) {
        StringBuilder sb = new StringBuilder();
        appointments.forEach(appointment -> {
            LocalDateTime start = appointment.getStart();
            LocalDateTime end = appointment.getEnd();
            String info = String.format("%d/%d/%d/%d/%d",
                start.getYear(), start.getMonthValue(), start.getDayOfMonth(),
                start.getHour(), end.getHour());
            sb.append(info).append(LINE_BREAK);
        });
        FileUtil.writeFile(filePath, sb.toString());
    }

    @Override
    @SneakyThrows
    public List<Appointment> load() {
        String records = FileUtil.readFile(filePath);
        if (records.isEmpty()) {
            return Lists.newArrayList();
        }
        return Arrays.stream(records.split(System.lineSeparator()))
            .map(Converter::convert)
            .collect(Collectors.toList());
    }
}
