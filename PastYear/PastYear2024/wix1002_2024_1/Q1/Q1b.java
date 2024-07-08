package wix1002_2024_1.Q1;

public class Q1b {
    public static double sumHarmonicSeries(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++)
            sum += 1 / (double) i;
        return sum;
    }
}
