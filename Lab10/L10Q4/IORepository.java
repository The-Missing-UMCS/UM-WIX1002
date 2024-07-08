package Lab10.L10Q4;

import java.io.*;
import java.util.*;
import java.time.LocalDateTime;

public class IORepository extends Repository {
    ArrayList<Appointment> appointmentList = new ArrayList<>();
    final String FILE = "C:\\Users\\User\\Desktop\\appointment.txt";

    @Override
    List<Appointment> getList() {
        return appointmentList;
    }

    public boolean makeAppointment(int year, int month, int day, int startTime, int endTime) {
        return makeAppointment(year, month, day, startTime, endTime, true);
    }

    public boolean makeAppointment(int year, int month, int day, int startTime, int endTime, boolean enabled) {
        LocalDateTime newStartTime = LocalDateTime.of(year, month, day, startTime, 0);
        LocalDateTime newEndTime = LocalDateTime.of(year, month, day, endTime, 0);

        for (Appointment a : appointmentList) {
            if (!a.search(newStartTime, newEndTime)) {
                if (enabled)
                    System.out.print(message(day, month, year, startTime, endTime, FAILED));
                return false;
            }
        }

        appointmentList.add(new Appointment(newStartTime, newEndTime));
        Collections.sort(appointmentList);
        if (enabled)
            System.out.print(message(day, month, year, startTime, endTime, SUCCESS));

        return true;
    }

    public void saveAppointment() {
        try (PrintWriter writer = new PrintWriter(FILE)) {
            for (Appointment a : appointmentList) {
                LocalDateTime startTime = a.getStartTime();
                LocalDateTime endTime = a.getEndTime();
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

    public void loadAppointment() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] info = line.split("/");
                makeAppointment(
                        Integer.parseInt(info[0]), // year
                        Integer.parseInt(info[1]), // month
                        Integer.parseInt(info[2]), // day
                        Integer.parseInt(info[3]), // startHour
                        Integer.parseInt(info[4]), // endHour
                        false); 
            }
            System.err.println("Load successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void doneAppointment() {
        appointmentList.remove(0);
    }

    public void doneAppointment(int n) {
        for (int i = 0; i < n; i++)
            appointmentList.remove(0);
    }

    private String message(int day, int month, int year, int startTime, int endTime, boolean isSuccess) {
        return String.format(" ==> %2d-%2d-%d -->  %2d:%2s ~ %2d:%2s  --> Appointment %s.\n",
                day, month, year, startTime, "00", endTime, "00", isSuccess ? "Success" : "Failed");
    }

}
