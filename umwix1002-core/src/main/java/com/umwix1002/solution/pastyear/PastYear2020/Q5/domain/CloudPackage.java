package com.umwix1002.solution.pastyear.PastYear2020.Q5.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public class CloudPackage extends Cloud {
    private final int coreCount;
    private final int memory;
    private final double hourlyRate;

    public CloudPackage(String cloudPackage, int coreCount, int memory, double hourlyRate) {
        super(cloudPackage);
        this.coreCount = coreCount;
        this.memory = memory;
        this.hourlyRate = hourlyRate;
    }

    public boolean canHandle(Job job) {
        return this.memory >= job.memory();
    }

    public void calculateTotalCost(Job job) {
        setTotalCost((double) job.taskCount() / this.coreCount * this.hourlyRate);
    }
}
