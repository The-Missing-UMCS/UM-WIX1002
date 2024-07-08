package Lab10.L10Q4;

import java.time.LocalDateTime;
import java.util.List;

public class Presenter {
    Repository repository;
    int size1 = 14, size2 = 14, size3 = 17;
    String format = "|%" + size1 + "s|%" + size2 + "s|%" + size3 + "s|\n";

    Presenter(Repository repository) {
        this.repository = repository;
    }

    String middleString(String s, int length) {
        if (s.length() >= length)
            return s.substring(0, length);

        int left = (length - s.length()) / 2;
        int right = length - s.length() - left;
        return " ".repeat(left) + s + " ".repeat(right);
    }

    public void present() {
        List<Appointment> appointmentList = repository.getList();

        System.out.print(decorator());
        System.out.printf(formatted("Appointment", "Date", "Time"));
        System.out.print(decorator());

        for (int i = 0; i < appointmentList.size(); i++) {
            Appointment appointment = appointmentList.get(i);
            LocalDateTime startTime = appointment.getStartTime();
            LocalDateTime endTime = appointment.getEndTime();
            System.out.printf(formatted(
                    i + 1 + "",
                    String.format("%02d-%02d-%d",
                            startTime.getDayOfMonth(),
                            startTime.getMonthValue(),
                            startTime.getYear()),
                    String.format("%02d:%02d - %02d:%02d",
                            startTime.getHour(), 0,
                            endTime.getHour(), 0)));
        }
        System.out.printf(formatted("", "", ""));
        System.out.printf(decorator());
    }

    private String formatted(String s1, String s2, String s3) {
        return String.format(format, middleString(s1, size1), middleString(s2, size2), middleString(s3, size3));
    }

    private String decorator() {
        return formatted("-".repeat(size1), "-".repeat(size2), "-".repeat(size3));
    }

}
