package com.umwix1002.solution.pastyear.PastYear2019.wix1002_2019_2.Q6;

public class Order {
    String customerName;
    String customerId;
    int quantity;
    double unitPrice;

    public Order() {
        this("Unknown", "Unknown", 1, 1);
    }

    public Order(String customerName, String customerId, int quantity, double unitPrice) {
        this.customerName = customerName;
        this.customerId = customerId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double computeTotalPrice() {
        return quantity * unitPrice;
    }

    @Override
    public String toString() {
        return String.format(
                "Order record\nCustomer Name : %s\nCustomer Id : %s\nQuantity ordered: %d\nUnit Price : %.1f\nTotal Price : %.1f",
                customerName, customerId, quantity, unitPrice, computeTotalPrice());
    }

}
