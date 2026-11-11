package org.example.order.service.discount.interfaces;

import org.example.order.model.Order;

public interface DiscountHandler {
    double calculateDiscount(Order order);
}
