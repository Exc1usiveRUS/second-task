package org.example.order.validation;

import org.example.order.model.Order;

public class OrderValidator {

    public void validate(Order order) {
        if (order.getAmount() <= 0) {
            throw new RuntimeException("Сумма оплаты должна быть выше нуля");
        }
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new RuntimeException("В заказе должен быть быть хотя бы один товар");
        }
    }
}
