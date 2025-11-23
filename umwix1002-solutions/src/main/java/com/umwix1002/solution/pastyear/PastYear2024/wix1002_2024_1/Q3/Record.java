package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_1.Q3;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.umwix1002.solution.Properties.PAST_YEAR;

public class Record {

    public static final String DELETED = "deleted";

    public static void main(String[] args) {
        String inputFile = PAST_YEAR + "PastYear2024/wix1002_2024_1/Q3/oaiset.csv";
        OAIRecord[] data = new OAIRecord[50];
        System.out.println("Loading Dataset...");
        loadRecord(inputFile, data);
        System.out.println("The curated record is as follow:");
        printRecord(cleanRecord(data));
        System.out.println("\nThe summary report is as follow:");
        reportData(cleanRecord(data));
    }

    private static OAIRecord[] cleanRecord(OAIRecord[] data) {
        return Arrays.stream(data)
            .distinct()
            .filter(record -> record != null && !StringUtils.equals(record.getStatus(), DELETED))
            .toArray(OAIRecord[]::new);
    }

    private static void printRecord(OAIRecord[] cleanedData) {
        Arrays.stream(cleanedData)
            .forEach(oaiRecord -> {
                String[] infos = new String[]{
                    String.format("%-16s", oaiRecord.getDoi()),
                    String.format("\"%s\"", oaiRecord.getTitle()),
                    oaiRecord.getSubject(),
                    String.format("{%s}", String.join(";", oaiRecord.getAuthors())),
                    oaiRecord.getKeyword(),
                    oaiRecord.getStatus()
                };
                System.out.println(String.join(" ".repeat(3), infos));
            });
    }

    private static void reportData(OAIRecord[] cleanedData) {
        // 1. Count the number of authors
        Map<String, Long> report = Arrays.stream(cleanedData)
            .map(OAIRecord::getAuthors)
            .flatMap(Collection::stream)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 2. Print the report
        report.keySet().forEach(author -> {
            String message = String.format("%s: %d", author, report.get(author));
            System.out.println(message);
        });
    }

    private static void loadRecord(String inputFile, OAIRecord[] data) {
        try (Scanner scanner = new Scanner(new FileInputStream(inputFile))) {
            // 1. Read the header
            scanner.nextLine();
            int index = 0;

            // 2. Read the data
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                OAIRecord oaiRecord = parseRecord(line);
                data[index++] = oaiRecord;
            }
        } catch (Exception e) {
//            System.out.println("Error loading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static OAIRecord parseRecord(String line) {
        String[] info = line.split(",");
        return OAIRecord.builder()
            .doi(info[0])
            .title(info[1])
            .subject(info[2])
            .authors(Arrays.asList(info[3].split(";")))
            .keyword(info[4])
            .status(info[5])
            .build();
    }
}
