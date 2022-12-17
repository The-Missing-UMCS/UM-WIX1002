package com.fyiernzy.Lab10;

import java.time.LocalDateTime;
import java.util.*;
import java.io.*;

// Reference: https://stackoverflow.com/questions/9560600/what-causes-error-no-enclosing-instance-of-type-foo-is-accessible-and-how-do-i
// Reference: https://github.com/LimJY03/WIX1002_UM/blob/main/Lab%2010/L10Q4/Appointment.java
// Reference: https://stackoverflow.com/questions/2277430/the-built-in-iterator-for-javas-priorityqueue-does-not-traverse-the-data-struct

public class L10Q4 {
	public static void main(String[] args) {
		
		Appointment.loadAppointment();
		Appointment.showAppointment();
		Appointment.makeAppointment(2022, 12, 16, 17, 19);
		Appointment.makeAppointment(2022, 12, 16, 12, 13);
		Appointment.makeAppointment(2022, 12, 17, 12, 13);
		Appointment.makeAppointment(2022, 12, 16, 11, 12);
		Appointment.makeAppointment(2023, 1, 1, 11, 12);
		Appointment.doneAppointment(2);
		Appointment.showAppointment();
	}
}

interface Searchable {
	boolean search(LocalDateTime dateStartTime, LocalDateTime dateEndTime);
}

class Appointment implements Searchable {
	private static ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
	private static final String FILE = "./src/com/fyiernzy/Lab10/io_files/appointment.txt";
	LocalDateTime dateStartTime;
	LocalDateTime dateEndTime;
	

	private Appointment(LocalDateTime dateStartTime, LocalDateTime dateEndTime) {
		this.dateStartTime = dateStartTime;
		this.dateEndTime = dateEndTime;
	}
	
	@Override
	public boolean search(LocalDateTime newStartTime, LocalDateTime newEndTime) {
		return (this.dateStartTime.isAfter(newEndTime) || this.dateEndTime.isBefore(newStartTime));
	}
	
	public static boolean makeAppointment(int year, int month, int day, int startTime, int endTime) {
		LocalDateTime newStartTime = LocalDateTime.of(year, month, day, startTime, 0);
		LocalDateTime newEndTime = LocalDateTime.of(year, month, day, endTime, 0);
		
		Iterator<Appointment> it = appointmentList.iterator();
		
		while(it.hasNext()) {
			Appointment appointment = it.next();
			if(appointment.search(newStartTime, newEndTime) == false) {
				return false;
			}
		}
		
		appointmentList.add(new Appointment(newStartTime, newEndTime));
		Collections.sort(appointmentList, new AppointmentComparator());
		return true;
	}
	
	public static void showAppointment() {
		Iterator<Appointment> it = appointmentList.iterator();
		int count = 0;
		System.out.printf(" %-11s | %7s    | %8s\n", "Appointment", "Date", "Time");
		System.out.printf(" %12s|%12s|%14s\n", "-".repeat(12),"-".repeat(12),"-".repeat(14));
		
		while(it.hasNext()) {
			count++;
			Appointment appointment = it.next();
			LocalDateTime startTime = appointment.getStartTime();
			LocalDateTime endTime = appointment.getEndTime();
			System.out.printf(" %10d  | %2d-%2d-%d | %2d:%2s - %2d:%2s\n",
					count, startTime.getDayOfMonth(), startTime.getMonthValue(), startTime.getYear(), 
					startTime.getHour(), "00", endTime.getHour(), "00");
		}
		
		System.out.printf(" %-11s | %7s    | %8s\n", "", "", "");
		System.out.printf(" %12s|%12s|%14s\n", "-".repeat(12),"-".repeat(12),"-".repeat(14));
	}
	
	private LocalDateTime getStartTime() {
		return this.dateStartTime;
	}
	
	private LocalDateTime getEndTime() {
		return this.dateEndTime;
	}
	
	public static void saveAppointment() {
		try(PrintWriter writer = new PrintWriter(FILE)) {
			Iterator<Appointment> it = appointmentList.iterator();
			StringBuilder sb = new StringBuilder();
			
			while(it.hasNext()) {
				Appointment appointment = it.next();
				LocalDateTime startTime = appointment.getStartTime();
				LocalDateTime endTime = appointment.getEndTime();
				String info = String.format("%d/%d/%d/%d/%d", 
						startTime.getYear(), startTime.getMonthValue(), startTime.getDayOfMonth(),
						startTime.getHour(), endTime.getHour());
				writer.println(info);
			}
			System.err.println("Save successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void loadAppointment() {
		try(BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
			String line = "";
			while((line = reader.readLine()) != null) {
				String[] info = line.split("/");
				makeAppointment(
						Integer.parseInt(info[0]), Integer.parseInt(info[1]), Integer.parseInt(info[2]),
						Integer.parseInt(info[3]), Integer.parseInt(info[4]));
			}
			System.err.println("Load successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void doneAppointment() {
		appointmentList.remove(0);
	}
	
	public static void doneAppointment(int n) {
		for(int i = 0; i < n; i++)
			appointmentList.remove(0);
	}
	
	static class AppointmentComparator implements Comparator<Appointment> {
		@Override
		public int compare(Appointment a1, Appointment a2) {
			return (a1.getStartTime().isAfter(a2.getStartTime()) ? 1 : -1);
		}
	}
	
}
