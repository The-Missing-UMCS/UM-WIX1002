package com.umwix1002.solution.pastyear.PastYear2020.Q4;

import java.io.*;
import java.util.HashMap;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) {
		String logFilePath = "umwix1002-core/src/main/java/com/umwix1002/solution/pastyear/PastYear2020/Q4/sampleLog";
		String[] logContents = readLogFile(logFilePath);
		displayLogRecords(logContents);
		displaySubmissionStats(logContents);
		displayJobStatus(logContents);
	}

	public static void displayJobStatus(String[] logContents) {
		HashMap<String, JobData> jobStatusMap = new HashMap<>();
		Pattern jobIdPattern = Pattern.compile(".*;[QSE];([0-9]{5})\\.ce2.*");
		Pattern queuePattern = Pattern.compile("Q.*;queue=(.*)");
		Pattern startPattern = Pattern.compile("S.*start=([0-9]*)");
		Pattern endPattern = Pattern.compile("E.*end=([0-9]*) Exit_status=([\\-0-9]*)");

		for (String line : logContents) {
			Matcher matcher = jobIdPattern.matcher(line);
			if (matcher.matches()) {
				String jobId = matcher.group(1);
				jobStatusMap.putIfAbsent(jobId, new JobData());

				matcher = queuePattern.matcher(line);
				if (matcher.find()) {
					jobStatusMap.get(jobId).setQueue(matcher.group(1));
					continue;
				}

				matcher = startPattern.matcher(line);
				if (matcher.find()) {
					jobStatusMap.get(jobId).setStartTime(matcher.group(1));
					continue;
				}

				matcher = endPattern.matcher(line);
				if (matcher.find()) {
					jobStatusMap.get(jobId).setExitTime(matcher.group(1));
					jobStatusMap.get(jobId).setExitStatus(matcher.group(2));
				}
			}
		}

		final String format = " %-13s%-23s%-26s%-20s%n";
		System.out.println("\n" + "*".repeat(50));
		System.out.println(" Job Status Report\n");
		System.out.printf(format, "Job ID", "Queue", "Start Time", "End Time / Exit Status");
		System.out.printf(format, "-".repeat(13), "-".repeat(23), "-".repeat(26), "-".repeat(20));

		jobStatusMap.forEach((jobId, jobData) -> System.out.printf(
			format,
			jobId,
			jobData.getQueue(),
			jobData.getStartTime(),
			jobData.getExitDetails()
		));
	}

	public static void displaySubmissionStats(String[] logContents) {
		HashMap<String, Integer> submissionStats = new HashMap<>();
		Pattern submissionPattern = Pattern.compile(".*[0-9:];S;.*user=(.*) group=.*");

		for (String line : logContents) {
			Matcher matcher = submissionPattern.matcher(line);
			if (matcher.find()) {
				String username = matcher.group(1);
				submissionStats.merge(username, 1, Integer::sum);
			}
		}

		System.out.println("\n" + "*".repeat(50));
		System.out.println(" Submission Statistics\n");
		System.out.printf(" %-16s%-20s%n", "User", "Jobs Submitted");
		System.out.printf(" %-16s%-20s%n", "-".repeat(16), "-".repeat(15));

		submissionStats.forEach((user, count) -> System.out.printf(" %-16s%-20d%n", user, count));
	}

	public static void displayLogRecords(String[] logContents) {
		System.out.println(" " + "*".repeat(50));
		System.out.println(" Log Records\n");

		for (int i = 0; i < logContents.length; i++) {
			System.out.printf(" Record %d:%n", i + 1);
			String[] logParts = logContents[i].split(" ");
			for (String part : logParts) {
				System.out.println("    " + part);
			}
		}

		System.out.println("\n Total records read: " + logContents.length);
	}

	public static String[] readLogFile(String filePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			StringBuilder fileContents = new StringBuilder();
			String line;

			while ((line = reader.readLine()) != null) {
				fileContents.append(line).append(System.lineSeparator());
			}

			return fileContents.toString().split(System.lineSeparator());
		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
			return new String[0];
		}
	}
}
