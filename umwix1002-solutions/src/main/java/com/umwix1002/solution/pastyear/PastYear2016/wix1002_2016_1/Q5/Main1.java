package com.umwix1002.solution.pastyear.PastYear2016.wix1002_2016_1.Q5;

import com.umwix1002.solution.pastyear.PastYear2016.wix1002_2016_1.Q5.Purchase.PurchaseType;

import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        Rebate r = new Rebate("John Lim", "1111222233334444");
        Point p = new Point("John Lim", "5555666677778888");

        List<Purchase> purchaseList = List.of(
                new Purchase(PurchaseType.GROCERY, Purchase.Day.SATURDAY, 124.80),
                new Purchase(PurchaseType.OTHER, Purchase.Day.FRIDAY, 64.60),
                new Purchase(PurchaseType.FUEL, Purchase.Day.SUNDAY, 95.40),
                new Purchase(PurchaseType.UTILITY, Purchase.Day.FRIDAY, 100.00),
                new Purchase(PurchaseType.OTHER, Purchase.Day.TUESDAY, 220.00));

        r.getReward(purchaseList);
        p.getReward(purchaseList);

        System.out.println(r);
        System.out.println(p);

        System.out.println(
                "The best card is " + (r.getTotalCashReward() > p.getTotalCashReward() ? CreditCard.TYPE_CASH_REBATE
                        : CreditCard.type_POINT_REWARD) + " Card");
    }
}
