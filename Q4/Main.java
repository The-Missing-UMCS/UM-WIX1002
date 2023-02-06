package PastYear2020.Q4;

import java.io.*;
import java.util.HashMap;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) {
		String FILE = "./src/PastYear2020/Q4/sampleLog";
		String[] content = readContent(FILE);
		printRecord(content);
		printSubmissionStat(content);
		printJobStatus(content);
	}
	
	public static void printJobStatus(String[] content) {
		HashMap<String, Data> status = new HashMap<>();
		Pattern jobID = Pattern.compile(".*;[QSE];([0-9]{5})\\.ce2.*");
		Pattern qType = Pattern.compile("Q.*;queue=(.*)");
		Pattern sType = Pattern.compile("S.*start=([0-9]*)");
		Pattern eType = Pattern.compile("E.*end=([0-9]*) Exit_status=([\\-0-9]*)");
		Matcher m;
		
		// Analyze the data
		for(String line : content) {			
			m = jobID.matcher(line);
			m.matches();
			String id = m.group(1);
			status.putIfAbsent(id, new Data());
			
			m = qType.matcher(line);
			if(m.find()) {
				status.get(id).setQueue(m.group(1));
				continue;
			}
			
			m = sType.matcher(line);
			if(m.find()) {
				status.get(id).setStart(m.group(1));
				continue;
			}
			
			m = eType.matcher(line);
			if(m.find()) {
				status.get(id).setExitTime(m.group(1));
				status.get(id).setExitStatus(m.group(2));
			}
		}
		
		// Print the analysis
		String[] label = {"Job ID", "Submitted [queue]", "Started (start time)", "Exited (end time/error)"};
		
		System.out.println("\n " + "*".repeat(50));
		System.out.println(" Print job status\n");
		System.out.printf(" %-13s%-23s%-26s%-20s\n", label[0], label[1], label[2], label[3]);
		System.out.printf(" %-13s%-23s%-26s%-20s\n", "-".repeat(label[0].length()), "-".repeat(label[1].length()), 
													 "-".repeat(label[2].length()), "-".repeat(label[3].length()));
		
		status.forEach((jobid, data) -> System.out.printf(" %-13s%-23s%-26s%-20s\n", jobid, data.getQueue(), data.getStart(), data.getExit()));
		System.out.println("\n " + "*".repeat(50));
		
	}
	
	public static void printSubmissionStat(String[] content) {
		// Analyze the data
		HashMap<String, Integer> stat = new HashMap<>();
		Pattern pattern = Pattern.compile(".*[0-9\\:];S;.*user=(.*) group=.*");
		Matcher matcher;
		for(String line : content) {
			matcher = pattern.matcher(line);
			if(matcher.find()) {
				String username = matcher.group(1);
				stat.put(username, stat.getOrDefault(username, 0) + 1);
			}
		}
		
		// Print the analysis
		System.out.println("\n " + "*".repeat(50));
		System.out.println(" Print user submission stat\n");
		System.out.printf(" %-16s%-20s\n", "User", "Jobs Submitted");
		System.out.printf(" %-16s%-20s\n", "-".repeat(4), "-".repeat("Jobs Submitted".length()));
		
		stat.forEach((username, count) -> System.out.printf(" %-16s%-20s\n", username, count));
	}
	
	public static void printRecord(String[] content) {
		int i = 0;
		System.out.println(" " + "*".repeat(50));
		System.out.println(" Records read from log file");
		for(; i < content.length; i++) {
			System.out.printf("\n Record %d:\n", i + 1);
			String[] parts = content[i].split(" ");
			for(String part : parts) {
				System.out.println(" ".repeat(4) + part);
			}
		}
		
		System.out.println("\n total record read: " + i);
	}
	
	public static String[] readContent(String file) {
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			System.out.println(" Reading from log file...");
			StringBuilder sb = new StringBuilder();
			char[] buff = new char[8192];
			int byteRead;
			while((byteRead = reader.read(buff)) != -1) {
				sb.append(buff, 0, byteRead);
			}
			return sb.toString().split(System.lineSeparator());
		} catch(IOException ex) {
			return new String[0];
		}
	}
}
