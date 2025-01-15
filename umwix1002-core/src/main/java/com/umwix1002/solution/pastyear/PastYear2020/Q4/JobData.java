package com.umwix1002.solution.pastyear.PastYear2020.Q4;

import lombok.Setter;

@Setter
public class JobData {
    private String queue;
    private String startTime;
    private String exitTime;
    private String exitStatus;

    public String getQueue() {
        return String.format("Y (%s)", this.queue);
    }

    public String getStartTime() {
        return String.format("Y (%s)", startTime);
    }

    public String getExitDetails() {
        if (null == exitStatus) {
            return null;
        }

        if (!exitStatus.equals("1")) {
            return "Error: Exit Status " + exitStatus;
        }

        return exitTime;
    }
}
