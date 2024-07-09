package wix1002_2018_1.Q5;

public class Watermelon extends Fruit {
    private static final String NAME = "WATERMELON";
    public static final String LOCAL = "LOCAL";
    public static final String IMPORTED = "IMPORTED";

    double weight;

    public Watermelon(String type, double weight) {
        super(Watermelon.NAME, type);
        this.weight = weight;
    }

    @Override
    public double totalPrice() {
        return weight * getPricePerKg();
    }

    private double getPricePerKg() {
        // | | Local | Imported |
        // | < 2kg | | |
        // | 2 - 5kg | | |
        // | > 5kg | | |

        double[][] prices = {
                { 2.25, 3.75 },
                { 1.95, 3.45 },
                { 1.65, 3.15 }
        };

        boolean isLocal = LOCAL.equals(type);
        int level = weight < 2 ? 0 : (weight > 5 ? 2 : 1);
        return prices[level][isLocal ? 0 : 1];
    }

    @Override
    public String toString() {
        return String.format("%s - %.1fkg = RM%.2f", super.toString(), weight, totalPrice());
    }

}
