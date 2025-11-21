package com.umwix1002.solution.lab.lab10.l10q4.l10q4c.service;

import com.umwix1002.solution.lab.lab10.l10q4.l10q4c.domain.Appointment;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RepositoryImpl implements Repository {

    private final Path path;

    private final TreeSet<Appointment> appointments = new TreeSet<>();

    private RepositoryImpl(String path) {
        this.path = Paths.get(path);
    }

    public static RepositoryImpl create(String path) {
        return new RepositoryImpl(path);
    }

    public static RepositoryImpl load(String path) {
        RepositoryImpl repo = new RepositoryImpl(path);
        repo.load();
        return repo;
    }

    @Override
    public boolean save(Appointment appointment) {
        return appointments.add(appointment);
    }

    @Override
    public void removeFirstN(int n) {
        for (int i = 0; i < n; i++) {
            appointments.remove(appointments.first());
        }
    }

    @Override
    public List<Appointment> searchWithinRange(LocalDateTime start, LocalDateTime end) {
        return appointments.stream()
            .filter(appointment -> appointment.search(start, end))
            .toList();
    }

    @Override
    public List<Appointment> findAll() {
        return appointments.stream().toList();
    }

    @Override
    @SneakyThrows
    public void persist() {
        String content = appointments.stream()
            .map(appointment -> {
                LocalDateTime start = appointment.getStart();
                LocalDateTime end = appointment.getEnd();
                return String.format("%d/%d/%d/%d/%d",
                    start.getYear(), start.getMonthValue(), start.getDayOfMonth(),
                    start.getHour(), end.getHour());
            })
            .collect(Collectors.joining(System.lineSeparator()));
        Files.writeString(path, content, StandardOpenOption.CREATE,
            StandardOpenOption.TRUNCATE_EXISTING);
    }

    @Override
    @SneakyThrows
    public void load() {
        String records = Files.readString(path);
        Set<Appointment> persisted = Arrays.stream(records.split(System.lineSeparator()))
            .filter(line -> !line.isEmpty())
            .map(Converter::convert)
            .collect(Collectors.toUnmodifiableSet());
        appointments.addAll(persisted);
    }
}
