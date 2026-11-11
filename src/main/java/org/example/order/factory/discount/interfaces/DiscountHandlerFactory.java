package org.example.order.factory.discount.interfaces;

import org.example.order.service.discount.interfaces.DiscountHandler;

public interface DiscountHandlerFactory {
    DiscountHandler create(String customerType);
}
