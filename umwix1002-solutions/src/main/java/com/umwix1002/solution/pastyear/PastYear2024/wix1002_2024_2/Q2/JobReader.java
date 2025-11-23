package com.umwix1002.solution.pastyear.PastYear2024.wix1002_2024_2.Q2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static com.umwix1002.solution.Properties.PAST_YEAR;

public class JobReader {
    public static void main(String[] args) {
        Job[] jobs = readJobsFromDirectory(PAST_YEAR + "PastYear2024/wix1002_2024_2/Q2/jobs.csv");
        listAllJobs(jobs);
        generateStatistics(jobs);
    }

    private static Job[] readJobsFromDirectory(String directoryPath) {
        try {
            String content = Files.readString(Path.of(directoryPath));
            String[] jobStrings = content.split("\\n");
            return Arrays.stream(jobStrings, 1, jobStrings.length)
                .map(jobString -> jobString.split(","))
                .map(jobData -> new Job(jobData[0], jobData[1], jobData[2], jobData[3]))
                .toArray(Job[]::new);
        } catch (Exception e) {
            System.out.printf("Error reading jobs from directory: %s%n", e.getMessage());
            return null;
        }
    }

    private static void listAllJobs(Job[] jobs) {
        System.out.println("List of all jobs:");
        Arrays.stream(jobs)
            .map(job -> String.format("Job Name: %s, Partition: %s, Memory: %s, QoS: %s",
                job.getJobName(), job.getPartition(), job.getMemory(), job.getQos()))
            .forEach(System.out::println);
        System.out.println();
    }

    private static void generateStatistics(Job[] jobs) {
        Map<String, Long> partitionStatistics = Arrays.stream(jobs)
            .collect(Collectors.groupingBy(Job::getPartition, Collectors.counting()));

        Map<String, Long> qosStatistics = Arrays.stream(jobs)
            .collect(Collectors.groupingBy(Job::getQos, Collectors.counting()));

        System.out.println("Partition Statistics:");
        partitionStatistics.forEach((partition, count) -> System.out.printf("%s: %d jobs%n", partition, count));

        System.out.println();

        System.out.println("QoS Statistics:");
        qosStatistics.forEach((qos, count) -> System.out.printf("%s: %d jobs%n", qos, count));
    }
}
