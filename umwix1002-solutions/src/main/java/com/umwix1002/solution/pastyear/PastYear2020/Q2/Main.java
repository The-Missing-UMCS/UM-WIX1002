package com.umwix1002.solution.pastyear.PastYear2020.Q2;

import com.umwix1002.solution.pastyear.PastYear2020.Q2.domain.Coordinate;
import com.umwix1002.solution.pastyear.PastYear2020.Q2.domain.Latitude;
import com.umwix1002.solution.pastyear.PastYear2020.Q2.domain.Longitude;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter Location 1: ");
            Coordinate c1 = getCoordinate(scanner);

            System.out.println("Enter Location 2: ");
            Coordinate c2 = getCoordinate(scanner);

            System.out.println("Location 1: " + c1);
            System.out.println("Location 2: " + c2);

            CoordinateDistanceCalculator calc = new CoordinateDistanceCalculator(c1, c2);
            System.out.printf("Distance: %.2f KM\n", calc.calcDistance());
        }
    }

    private static Coordinate getCoordinate(Scanner scanner) {
        System.out.print("Enter Latitude Direction: [N, S]: ");
        char latDirection = scanner.nextLine().charAt(0);

        System.out.print("Enter Latitude Degree, Minute and Second: ");
        int latDegree = scanner.nextInt();
        int latMinute = scanner.nextInt();
        int latSecond = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Longitude Direction: [E, W]: ");
        char longDirection = scanner.nextLine().charAt(0);

        System.out.print("Enter Longitude Degree, Minute and Second: ");
        int longDegree = scanner.nextInt();
        int longMinute = scanner.nextInt();
        int longSecond = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Latitude latitude = new Latitude(latDirection, latDegree, latMinute, latSecond);
        Longitude longitude = new Longitude(longDirection, longDegree, longMinute, longSecond);

        return new Coordinate(latitude, longitude);
    }
}
