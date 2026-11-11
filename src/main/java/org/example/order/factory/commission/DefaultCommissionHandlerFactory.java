package org.example.order.factory.commission;

import org.example.order.factory.commission.interfaces.CommissionHandlerFactory;
import org.example.order.service.commision.CardCommissionHandler;
import org.example.order.service.commision.CashCommissionHandler;
import org.example.order.service.commision.TransferCommissionHandler;
import org.example.order.service.commision.interfaces.CommissionHandler;

import java.util.Map;

public class DefaultCommissionHandlerFactory implements CommissionHandlerFactory {

    private static final Map<String, CommissionHandler> REGISTRY = Map.of(
            "CARD", new CardCommissionHandler(),
            "CASH", new CashCommissionHandler(),
            "TRANSFER", new TransferCommissionHandler()
    );

    @Override
    public CommissionHandler create(String paymentType) {
        CommissionHandler handler = REGISTRY.get(paymentType);
        if (handler == null) {
            throw new RuntimeException("Неизвестный тип платежа: " + paymentType);
        }
        return handler;
    }
}
