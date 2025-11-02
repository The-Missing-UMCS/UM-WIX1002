package com.umwix1002.solution.pastyear.PastYear2020.Q2;

public class Tester {
    public static void main(String[] args) {
        // 1. Get user input
        char loc1LongDirection = 'W';
        int[] loc1long = {21, 19, 8};
        // ArrayList

        char loc1LatDirection = 'N';
        int[] loc1lat = {32, 45, 51};

        char loc2LongDirection = 'E';
        int[] loc2long = {13, 22, 58};

        char loc2LatDirection = 'S';
        int[] loc2lat = {8, 11, 20};

        // 2. Conversion
        double loc1Long = loc2long[0] + (loc2long[1] / (double) 60) + (loc2long[2] / (double) (60 * 60));
        double loc1Lat = loc1lat[0] + (loc1lat[1] / (double) 60) + (loc1lat[2] / (double) (60 * 60));

        double loc2Long = loc2long[0] + (loc2long[1] / (double) 60) + (loc2long[2] / (double) (60 * 60));
        double loc2Lat = loc2lat[0] + (loc2lat[1] / (double) 60) + (loc2lat[2] / (double) (60 * 60));

        loc1Long = loc1Long * (loc1LongDirection == 'E' ? 1 : -1);
        loc1Lat = loc1Lat * (loc1LatDirection == 'N' ? 1 : -1);
        loc2Long = loc2Long * (loc2LongDirection == 'E' ? 1 : -1);
        loc2Lat = loc1Lat * (loc2LatDirection == 'N' ? 1 : -1);

        // 3. Calculate
        double a = Math.pow(Math.sin(Math.abs(loc1Lat - loc2Lat)), 2)
            + Math.cos(loc1Lat) * Math.cos(loc2Lat) * Math.pow(Math.sin((loc1Long - loc2Long) / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = 6371 * c;
        System.out.println(d);
    }
}
