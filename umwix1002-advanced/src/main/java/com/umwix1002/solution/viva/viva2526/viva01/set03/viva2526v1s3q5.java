package com.umwix1002.solution.viva.viva2526.viva01.set03;

import java.util.Scanner;

public class viva2526v1s3q5 {

    public static void main(String[] args) {
        String input = """
            Apollo-11
            250000
            20000
            1
            Voyager-1
            1000000
            150000
            3
            STOP
            """;

        // We assume that users always provide complete entries before typing STOP
        try (Scanner scanner = new Scanner(input)) {
            String spaceCraftName;
            while (!"STOP".equals((spaceCraftName = scanner.next()))) {
                long distanceTravelled;
                while (true) {
                    distanceTravelled = scanner.nextLong();
                    if (distanceTravelled >= 0) {
                        break;
                    }
                    System.out.println("Invalid input! Distance must be positive numbers.");
                }

                long fuelUsed;
                while (true) {
                    fuelUsed = scanner.nextLong();
                    if (fuelUsed > 0) {
                        break;
                    }
                    System.out.println("Invalid input! Fuel must be positive numbers.");
                }

                int spaceCraftType;
                while (true) {
                    spaceCraftType = scanner.nextInt();
                    if (spaceCraftType >= 1 && spaceCraftType <= 3) {
                        break;
                    }
                    System.out.println("Invalid input! Spacecraft type must be between 1 and 3.");
                }

                // 2. Calculate efficiency and determine efficiency level
                double efficiency = (double) distanceTravelled / fuelUsed;
                String type = switch (spaceCraftType) {
                    case 1 -> "Rocket";
                    case 2 -> "Shuttle";
                    case 3 -> "Probe";
                    default -> "Unknown";
                };

                String performance;
                if (efficiency > 10) {
                    performance = "Outstanding performance! Minimal fuel usage.";
                } else if (efficiency >= 5) {
                    performance = "Good performance! Efficient mission.";
                } else {
                    performance = "Needs improvement! High fuel consumption.";
                }

                String missionTip = switch ((int) (Math.random() * 2 + 1)) {
                    case 1 -> "Always monitor fuel ratios before takeoff!";
                    case 2 -> "Plan trajectories to minimize unnecessary burns.";
                    case 3 -> "Efficient engines can save both fuel and cost.";
                    default -> "Keep missions safe and efficient!";
                };

                System.out.printf("""
                    Spacecraft: %s
                    Type: %s
                    Fuel Efficiency: %.1f km/l
                    Performance: %s
                    Mission Tip: %s
                    
                    """, spaceCraftName, type, efficiency, performance, missionTip);
            }
        }
    }
}
