package org.example.order.service.print.interfaces;

import org.example.order.model.Order;

public interface Printer {
    void print(Order order, double discount, double commission, double finalAmount);
}
