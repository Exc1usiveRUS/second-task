package org.example.order.factory.commission.interfaces;

import org.example.order.service.commision.interfaces.CommissionHandler;

public interface CommissionHandlerFactory {
    CommissionHandler create(String paymentType);
}
