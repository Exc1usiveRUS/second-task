package org.example.order.model;

import java.util.List;

public class Order {

    private final String id;
    private final String customerType; // "REGULAR", "VIP", "PREMIUM"
    private final String paymentType;  // "CARD", "CASH", "TRANSFER"
    private final List<String> items;
    private final double amount;

    public Order(String id, String customerType, String paymentType, List<String> items, double amount) {
        this.id = id;
        this.customerType = customerType;
        this.paymentType = paymentType;
        this.items = items;
        this.amount = amount;
    }

    public String getId() { return id; }
    public String getCustomerType() { return customerType; }
    public String getPaymentType() { return paymentType; }
    public List<String> getItems() { return items; }
    public double getAmount() { return amount; }
}
