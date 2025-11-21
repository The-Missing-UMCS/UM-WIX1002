package com.umwix1002.solution.pastyear.PastYear2019.wix1002_2019_1.Q5;

public class SpecialDelivery extends Delivery {
    private final boolean isWeekend;
    private final boolean isNightTime;
    
    SpecialDelivery(String sender, String recipient, double weight, boolean isNightTime, boolean isWeekend) {
        super(sender, recipient, weight);
        this.isNightTime = isNightTime;
        this.isWeekend = isWeekend;
    }
    
    @Override
    public double totalCost(){
        return (super.totalCost() + ((isNightTime) ? 50 : 0)) * ((isWeekend) ? 1.2 : 1) ;
    }
    
    @Override
    public String toString(){
        return String.format("%s%s%s", super.toString(),
                (isWeekend) ? "Weekend Delivery\n" : "",
                (isNightTime) ? "Night Time Delivery\n" : "");
    }
    
}
