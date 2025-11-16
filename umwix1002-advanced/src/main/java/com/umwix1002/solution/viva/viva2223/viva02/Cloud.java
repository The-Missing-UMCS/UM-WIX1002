package com.umwix1002.solution.viva.Viva_2223.Viva2;

import lombok.Getter;

public class Cloud {
    protected final String CLOUD_PACKAGE;
    @Getter
    protected double totalCost;

    Cloud(String cloudPackage) {
        this.CLOUD_PACKAGE = cloudPackage;
    }

    @Override
    public String toString() {
        return String.format("Cloud Package : %s  Total Cost= %.2f", this.CLOUD_PACKAGE, this.getTotalCost());
    }
}
