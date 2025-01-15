package com.umwix1002.solution.tutorial.Tutorial10.L10T2;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Account implements Interest {
    private final double balance;
    private final double interestRate;

    @Override
    public double computeInterest() {
        return (this.balance * this.interestRate / 12);
    }
}
