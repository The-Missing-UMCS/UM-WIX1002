package com.fyiernzy.Lab10;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.*;
import java.io.*;

// Duplicate value & order
public class L10Q4 {
	public static void main(String[] args) {
		Appointment.loadAppointment();
		Appointment.showAppointment();
	}
}

interface Searchable {
	boolean search(LocalDateTime dateStartTime, LocalDateTime dateEndTime);
}

class Appointment implements Searchable {
	private static Queue<Appointment> appointmentQueue = new LinkedBlockingQueue<Appointment>();
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
		LocalDateTime newStartTime = LocalDateTime.of(year, month, day, startTime, 00, 00);
		LocalDateTime newEndTime = LocalDateTime.of(year, month, day, endTime, 00, 00);
		
		Iterator<Appointment> it = appointmentQueue.iterator();
		
		while(it.hasNext()) {
			if(it.next().search(newStartTime, newEndTime) == false)
				return false;
		}
		
		appointmentQueue.add(new Appointment(newStartTime, newEndTime));
		return true;
	}
	
	public static void showAppointment() {
		Iterator<Appointment> it = appointmentQueue.iterator();
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
			Iterator<Appointment> it = appointmentQueue.iterator();
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
		appointmentQueue.poll();
	}
}
