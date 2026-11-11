package org.example.order.factory.discount;

import org.example.order.factory.discount.interfaces.DiscountHandlerFactory;
import org.example.order.service.discount.PremiumDiscountHandler;
import org.example.order.service.discount.RegularDiscountHandler;
import org.example.order.service.discount.VipDiscountHandler;
import org.example.order.service.discount.interfaces.DiscountHandler;

import java.util.Map;

public class DefaultDiscountHandlerFactory implements DiscountHandlerFactory {

    private static final Map<String, DiscountHandler> REGISTRY = Map.of(
            "REGULAR", new RegularDiscountHandler(),
            "VIP", new VipDiscountHandler(),
            "PREMIUM", new PremiumDiscountHandler()
    );

    @Override
    public DiscountHandler create(String customerType) {
        DiscountHandler handler = REGISTRY.get(customerType);
        if (handler == null) {
            throw new RuntimeException("Неизвестный тип клиента: " + customerType);
        }
        return handler;
    }
}
