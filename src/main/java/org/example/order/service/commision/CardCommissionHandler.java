package org.example.order.service.commision;

import org.example.order.model.Order;
import org.example.order.service.commision.interfaces.CommissionHandler;

public class CardCommissionHandler implements CommissionHandler {

    @Override
    public double calculateCommission(Order order) {
        return order.getAmount() * 0.02;
    }
}
