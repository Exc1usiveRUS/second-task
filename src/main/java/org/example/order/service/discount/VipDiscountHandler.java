package org.example.order.service.discount;

import org.example.order.model.Order;
import org.example.order.service.discount.interfaces.DiscountHandler;

public class VipDiscountHandler implements DiscountHandler {

    @Override
    public double calculateDiscount(Order order) {
        return order.getAmount() * 0.05;
    }
}
