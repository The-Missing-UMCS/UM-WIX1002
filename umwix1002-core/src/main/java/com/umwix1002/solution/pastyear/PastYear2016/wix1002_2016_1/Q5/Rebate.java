package com.umwix1002.solution.pastyear.PastYear2016.wix1002_2016_1.Q5;

import com.umwix1002.solution.pastyear.PastYear2016.wix1002_2016_1.Q5.CreditCard;

import java.util.List;

public class Rebate extends CreditCard {
    Rebate(String name, String cardNo) {
        super(name, cardNo, CreditCard.TYPE_CASH_REBATE);
    }

    @Override
    public void getReward(List<Purchase> purchaseList) {
        for(Purchase p : purchaseList) {
            switch(p.getType()) {
                case GROCERY -> totalCashReward += p.getAmount() * 0.02;
                case OTHER -> totalCashReward += p.getAmount() * 0.002;
                case FUEL -> totalCashReward += p.getAmount() * 0.08;
                case UTILITY -> totalCashReward += p.getAmount() * 0.05;
            }
        }
    }
}
