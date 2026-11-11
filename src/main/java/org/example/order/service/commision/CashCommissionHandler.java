package org.example.order.service.commision;

import org.example.order.model.Order;
import org.example.order.service.commision.interfaces.CommissionHandler;

public class CashCommissionHandler implements CommissionHandler {

    @Override
    public double calculateCommission(Order order) {
        return 0.0;
    }
}
