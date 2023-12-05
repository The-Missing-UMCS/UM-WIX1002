package PastYear.PastYear2016.Semester1.Q5;

public class Purchase {
    public static enum PurchaseType {
        GROCERY, OTHER, FUEL, UTILITY;        
    }

    public static enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }

    private final PurchaseType TYPE;
    private final Day DAY;
    private final double AMOUNT;

    public Purchase(PurchaseType type, Day day, double amount) {
        this.TYPE = type;
        this.DAY = day;
        this.AMOUNT = amount;
    }

    public PurchaseType getType() {
        return TYPE;
    }

    public Day getDay() {
        return DAY;
    }

    public double getAmount() {
        return AMOUNT;
    }


}
