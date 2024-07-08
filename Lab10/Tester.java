package Lab10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream("Appointment.txt"));
            out.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        searchAndSave(new Appointment(9, 1, 2024, 1000, 1300));
        searchAndSave(new Appointment(9, 1, 2024, 1100, 1400));
        searchAndSave(new Appointment(9, 1, 2024, 1330, 1630));
    }

    public static void searchAndSave(Appointment a) {
        if (a.search(a.getDateStartTime(), a.getDateStartTime())) {
            a.saveAppointment();
        } else {
            System.out.println("Please choose another appointment date and time.");
        }
    }
}

interface Searchable {
    boolean search(String dateStartTime, String dateEndTime);
}

class Appointment implements Searchable {
    // dateStartTime and dateEndTime = day/month/year/startTime or endTime
    private String dateStartTime, dateEndTime;

    public Appointment(int day, int month, int year, int startTime, int endTime) {
        this.dateStartTime = day + "/" + month + "/" + year + "/" + startTime;
        this.dateEndTime = day + "/" + month + "/" + year + "/" + endTime;
    }

    public boolean search(String dateStartTime, String dateEndTime) {
        try {
            Scanner in = new Scanner(new FileInputStream("Appointment.txt"));
            String[] dateStartTimeArray = dateStartTime.split("/");
            String[] dateEndTimeArray = dateEndTime.split("/");
            // store separately
            int day = Integer.parseInt(dateStartTimeArray[0]);
            int month = Integer.parseInt(dateStartTimeArray[1]);
            int year = Integer.parseInt(dateStartTimeArray[2]);
            int startTime = Integer.parseInt(dateStartTimeArray[3]);
            int endTime = Integer.parseInt(dateEndTimeArray[3]);
            // read the old appointments
            while (in.hasNextLine()) {
                String[] appointmentDateStartTimeArray = in.nextLine().split("/");
                String[] appointmentDateEndTimeArray = in.nextLine().split("/");
                in.nextLine();
                int appointment_day = Integer.parseInt(appointmentDateStartTimeArray[0]);
                int appointment_month = Integer.parseInt(appointmentDateStartTimeArray[1]);
                int appointment_year = Integer.parseInt(appointmentDateStartTimeArray[2]);
                int appointment_startTime = Integer.parseInt(appointmentDateStartTimeArray[3]);
                int appointment_endTime = Integer.parseInt(appointmentDateEndTimeArray[3]);

                // check date and time
                if (appointment_day == day && appointment_month == month && appointment_year == year) {
                    if (appointment_startTime <= endTime && appointment_endTime >= startTime) {
                        return false;
                    }
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return true;
    }

    // save appointment
    public void saveAppointment() {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream("Appointment.txt", true), true);
            out.println(this.dateStartTime);
            out.println(this.dateEndTime);
            out.println();
            out.close();
            System.out.println("Appointment saved.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public String getDateStartTime() {
        return this.dateStartTime;
    }

    public String getDateEndTime() {
        return this.dateEndTime;
    }
}