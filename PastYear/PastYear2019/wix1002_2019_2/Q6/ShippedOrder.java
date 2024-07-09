package wix1002_2019_2.Q6;

public class ShippedOrder extends Order {
    public ShippedOrder(String customerName, String customerId, int quantity, double unitPrice) {
        super(customerName, customerId, quantity, unitPrice);
    }

    @Override
    public double computeTotalPrice() {
        return super.computeTotalPrice() + 4;
    }

    @Override
    public String toString() {
        return String.format("Shipped\n%s", super.toString());
    }
}
