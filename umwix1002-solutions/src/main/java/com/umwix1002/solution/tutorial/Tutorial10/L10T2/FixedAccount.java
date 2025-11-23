package com.umwix1002.solution.tutorial.Tutorial10.L10T2;

public class FixedAccount extends Account {
    FixedAccount(int balance) {
        super(balance, (3 / (double) 100));
    }
}
