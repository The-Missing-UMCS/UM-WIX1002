package PastYear2016.Semester1.Q5;

import java.util.List;

import PastYear2016.Semester1.Q5.Purchase.Day;
import PastYear2016.Semester1.Q5.Purchase.PurchaseType;

public class Main1 {
    public static void main(String[] args) {
        Rebate r = new Rebate("John Lim", "1111222233334444");
        Point p = new Point("John Lim", "5555666677778888");

        List<Purchase> purchaseList = List.of(
                new Purchase(PurchaseType.GROCERY, Day.SATURDAY, 124.80),
                new Purchase(PurchaseType.OTHER, Day.FRIDAY, 64.60),
                new Purchase(PurchaseType.FUEL, Day.SUNDAY, 95.40),
                new Purchase(PurchaseType.UTILITY, Day.FRIDAY, 100.00),
                new Purchase(PurchaseType.OTHER, Day.TUESDAY, 220.00));

        r.getReward(purchaseList);
        p.getReward(purchaseList);

        System.out.println(r);
        System.out.println(p);

        System.out.println(
                "The best card is " + (r.getTotalCashReward() > p.getTotalCashReward() ? CreditCard.TYPE_CASH_REBATE
                        : CreditCard.type_POINT_REWARD) + " Card");
    }
}
