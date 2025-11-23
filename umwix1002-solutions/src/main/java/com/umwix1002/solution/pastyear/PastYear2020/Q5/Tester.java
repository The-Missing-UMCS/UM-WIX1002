package com.umwix1002.solution.pastyear.PastYear2020.Q5;

import com.umwix1002.solution.pastyear.PastYear2020.Q5.domain.CloudPackage;
import com.umwix1002.solution.pastyear.PastYear2020.Q5.domain.Job;

import java.util.Arrays;

import static java.util.Comparator.comparingDouble;

public class Tester {
    public static void main(String[] args) {
        Job[] jobs = {
            new Job("J1", 252, 20),
            new Job("J2", 108, 10),
            new Job("J3", 72, 25)
        };

        CloudPackage[] packages = {
            new CloudPackage("P2-15", 4, 15, 1.24),
            new CloudPackage("P2-30", 6, 30, 2.11),
            new CloudPackage("R5-20", 4, 20, 1.38),
            new CloudPackage("R6-20", 6, 20, 1.88)
        };

        double totalCost = 0;

        for (Job job : jobs) {
            System.out.println(job);
            CloudPackage bestPackage = findLeastCostPackage(packages, job);
            totalCost += bestPackage.getTotalCost();
            System.out.println(bestPackage);
        }

        System.out.printf("Total Cloud Cost: RM %.2f%n", totalCost);
    }

    public static CloudPackage findLeastCostPackage(CloudPackage[] packages, Job job) {
        return Arrays.stream(packages)
            .filter(pkg -> pkg.canHandle(job))
            .peek(pkg -> pkg.calculateTotalCost(job))
            .min(comparingDouble(CloudPackage::getTotalCost))
            .orElseThrow(() -> new IllegalArgumentException("No suitable package found for job: " + job.jobName()));
    }
}
