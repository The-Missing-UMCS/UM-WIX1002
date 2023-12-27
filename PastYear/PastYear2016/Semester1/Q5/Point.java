package PastYear2016.Semester1.Q5;

import java.util.List;

public class Point extends CreditCard {
    private double cashPerPoint = 0.01;

    Point(String name, String cardNo) {
        super(name, cardNo, CreditCard.type_POINT_REWARD);
    }

    @Override
    public void getReward(List<Purchase> purchaseList) {
        for(Purchase p : purchaseList) {
            switch(p.getDay()) {
                case FRIDAY -> totalCashReward += (int) p.getAmount() * cashPerPoint * 2;
                case SATURDAY -> totalCashReward += (int) p.getAmount() * cashPerPoint * 3;
                case SUNDAY -> totalCashReward += (int) p.getAmount() * cashPerPoint * 4;
                default -> totalCashReward += (int) p.getAmount() * cashPerPoint;
            }
        }
    }
}
