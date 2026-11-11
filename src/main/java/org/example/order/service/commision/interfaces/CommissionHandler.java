package org.example.order.service.commision.interfaces;

import org.example.order.model.Order;

public interface CommissionHandler {
    double calculateCommission(Order order);
}
