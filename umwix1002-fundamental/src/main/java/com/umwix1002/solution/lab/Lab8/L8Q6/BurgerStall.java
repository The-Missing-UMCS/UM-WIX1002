package com.umwix1002.solution.lab.Lab8.L8Q6;

import lombok.Getter;

public class BurgerStall {
    @Getter
    static int allSales;

    private final String ID;
    @Getter
    private int totalSold;

    BurgerStall(String ID) {
        this.ID = ID;
        this.totalSold = 0;
    }

    public void sold(int count) {
        if (count > 0) {
            this.totalSold += count;
            allSales += count;
        }
    }

    @Override
    public String toString() {
        return this.ID;
    }
}
