package org.example.order.service.discount;

import org.example.order.model.Order;
import org.example.order.service.discount.interfaces.DiscountHandler;

public class RegularDiscountHandler implements DiscountHandler {

    @Override
    public double calculateDiscount(Order order) {
        return 0.0;
    }
}
