package Q1;

import java.util.*;

public class Aran {
    private static int[] jobAdvMap = new int[] { 10, 30, 60, 100, 200, 260};

    int lvl, jobAdvancement;

    Aran() { this(-1); }

    Aran(int jobAdvancement) {
        this.lvl = level(jobAdvancement);
        this.jobAdvancement = jobAdvancement;
    }

    private static int level(int jobAdvancement) {
        if(jobAdvancement == -1) return 300;
        if (jobAdvancement >= 6 || jobAdvancement < 0) return -1;
        return jobAdvMap[jobAdvancement];
    }

    public int getJobAdvancement() {
        return this.jobAdvancement;
    }

    public void setJobAdvancement(int jobAdvancement) {
        this.jobAdvancement = jobAdvancement;
        this.lvl = level(jobAdvancement);
    }

    public static boolean isValid(String input) {
        if (!input.matches(".*[PTMQ].*"))
            return false;
        String bef = "BD", aft = "GH";
        Set<String> eval = Set.of("PT", "TM", "MQ", "BP", "DT", "MG", "QH");
        for (int j = 1; j < input.length(); j++) {
            char a = input.charAt(j - 1), b = input.charAt(j);
            if (eval.contains(a + "" + b) ||
                    bef.contains(b + "") || aft.contains(a + "") ||
                    Character.isDigit(a) || Character.isDigit(b))
                continue;
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("Aran Info\n%-10s%3d\n%-10s%3d\n", "Level: ", this.lvl, "Job Adv: ",
                this.jobAdvancement);
    }
}
