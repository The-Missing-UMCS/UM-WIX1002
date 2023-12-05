package PastYear.PastYear2016.Semester1.Q5;

import java.util.List;
import PastYear.PastYear2016.Semester1.Q5.Purchase.Day;
import PastYear.PastYear2016.Semester1.Q5.Purchase.PurchaseType;

public class Main2 {
    public static void main(String[] args) {
        CreditCard[] cardList = new CreditCard[] {
            new Rebate("John Lim", "1111222233334444"),
            new Point("John Lim", "5555666677778888")
        };
        
        List<Purchase> purchaseList = List.of(
                new Purchase(PurchaseType.GROCERY, Day.SATURDAY, 124.80),
                new Purchase(PurchaseType.OTHER, Day.FRIDAY, 64.60),
                new Purchase(PurchaseType.FUEL, Day.SUNDAY, 95.40),
                new Purchase(PurchaseType.UTILITY, Day.FRIDAY, 100.00),
                new Purchase(PurchaseType.OTHER, Day.TUESDAY, 220.00));
        
        CreditCard bestCard = cardList[0];

        for(CreditCard c : cardList) {
            c.getReward(purchaseList);
            System.out.println(c);
            bestCard = c.getTotalCashReward() > bestCard.getTotalCashReward() ? c : bestCard;
        }

        System.out.printf("The best card is %s Card.\n", bestCard.getType());
    }
}
